public class MenuHelper {
    private static final String TEMP_ROOT_FOLDER = "DCMGEN";
    private static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
    private static final String FOLDERTREE_STR = "foldertree=";
    private static final String RECORD_ELEMENT_DELIM = "[\\|]+";
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static Map<String, List<MegaMenuDTO>> parentChildMap = new LinkedHashMap<String, List<MegaMenuDTO>>();
    private static Map<String, String> idNameMap = new LinkedHashMap<String, String>();

    //Test this helper class....
    public static void main(String[] args) throws IOException {
        final String FOLDER_STRUCTURE = "id=0c06c81c8052324b;name=Documentation;type=cabinet;|id=0b06c81c80524a87;name=ABC;type=folder;parent=0c06c81c8052324b;|id=0b06c81c80524837;name=Admin;type=folder;parent=0b06c81c80524a87;|id=0b06c81c8052483d;name=Admin 2.0;type=folder;parent=0b06c81c80524837;|id=0b06c81c8052483a;name=Panel;type=folder;parent=0b06c81c80524a87;|id=0b06c81c8052484a;name=VCM;type=folder;parent=0b06c81c8052483a;|id=0c06c81c80269e63;name=Invoices;type=cabinet;|id=0b06c81c8026a008;name=other;type=folder;parent=0c06c81c80269e63;|id=0b06c81c8027a600;name=Workflow;type=folder;parent=0b06c81c8026a008;|id=0b06c81c8027a601;name=Worksheet;type=folder;parent=0b06c81c8027a600;|id=0c06c81c8051c7d3;name=Receipts;type=cabinet;|id=0b06c81c80545f32;name=VR_2;type=folder;parent=0c06c81c8051c7d3;|id=0b06c81c80545f33;name=VR_3;type=folder;parent=0c06c81c8051c7d3;|id=0b06c81c80545f30;name=VR_1;type=folder;parent=0c06c81c8051c7d3;|id=0b06c81c8053486d;name=VR;type=folder;parent=0c06c81c8051c7d3;|id=0b06c81c80545f31;name=test2;type=folder;parent=0b06c81c8053486d;|id=0c06c81c8051c7d2;name=Source;type=root;|id=0b06c81c80524a8b;name=gem;type=folder;parent=0c06c81c8051c7d2;|id=0b06c81c80521681;name=Code;type=folder;parent=0b06c81c80524a8b;|id=0b06c81c8051cba7;name=pfm;type=folder;parent=0b06c81c80524a8b;";

        System.out.println("Temp folder : " + System.getProperty(JAVA_IO_TMPDIR));

        List<FolderObj> folders = MenuHelper.parseResponseString(FOLDER_STRUCTURE);
        if(folders != null) {
            List<MegaMenuDTO> menuDTOList = MenuHelper.prepareMenu(folders);
            List<File> rootDirs = new ArrayList<>();
            File rootDir = new File(System.getProperty(JAVA_IO_TMPDIR) + SEPARATOR + TEMP_ROOT_FOLDER);
            //Check and Delete the root folder, if present, before processing.
            if(rootDir.exists()) {
                rootDirs.add(rootDir);
                for(File file : rootDirs) {
                    recursivelyDelete(file);
                }
            }

            //Create a fresh root dir.
            rootDirs.clear();
            rootDir = createTempRootDir(TEMP_ROOT_FOLDER);
            rootDirs.add(rootDir);

            //System.out.println("Tree : " + menuDTOList);
            for(MegaMenuDTO mmd: menuDTOList){
                printMenu(mmd, "\t");
                captureIdNameMap(mmd);
                printPaths(mmd, TEMP_ROOT_FOLDER + SEPARATOR + mmd.getName());
            }

            for (Map.Entry<String, List<MegaMenuDTO>> entry : parentChildMap.entrySet()) {
                String key = entry.getKey();
                List<MegaMenuDTO> value = entry.getValue();
                for(MegaMenuDTO dto : value) {
                    if(idNameMap.get(key) == null) {
                        System.out.println("Children of " + key + " -> " + dto.getName() + ", ID: " + dto.getId());
                    } else {
                        System.out.println("Children of " + idNameMap.get(key) + " -> " + dto.getName() + ", ID: " + dto.getId());
                    }
                }
            }

            System.out.println("--------------------------------------\n");
            for (Map.Entry<String, List<MegaMenuDTO>> entry : parentChildMap.entrySet()) {
                String key = entry.getKey();
                List<MegaMenuDTO> value = entry.getValue();
                if(key.equals("ROOT")) {
                    for(MegaMenuDTO dto : value) {
                        System.out.println("Root Folder is : " + dto.getName());
                        //createTempRootDir(TEMP_ROOT_FOLDER + SEPARATOR + dto.getName());
                        System.out.println(TEMP_ROOT_FOLDER + SEPARATOR + dto.getName());
                        printFoldersRecursively(parentChildMap.get(dto.getId()), TEMP_ROOT_FOLDER + SEPARATOR + dto.getName());                             
                    }
                }
            }
        }
    }

    public static void printFoldersRecursively(List<MegaMenuDTO> value, String rootPath) throws IOException {
         for (MegaMenuDTO inDTO1 : value) {
             System.out.println(rootPath + SEPARATOR + inDTO1.getName());
             for(MegaMenuDTO childItem : inDTO1.getChildrenItems()) {
                 System.out.println(rootPath + SEPARATOR + inDTO1.getName() + SEPARATOR + childItem.getName());
                 printFoldersRecursively(childItem.getChildrenItems(), rootPath + SEPARATOR + inDTO1.getName() + SEPARATOR + childItem.getName());
             }
         }
    }

    public static List<FolderObj> parseResponseString(final String input) {
        if(input == null) {
            return null;
        }
        List<FolderObj> menuList = new ArrayList<>();
        String[] parsedValues = input.split(RECORD_ELEMENT_DELIM);
        for(short i=0; i < parsedValues.length; i++) {
            menuList.add(digest(filterValue(parsedValues[i])));
        }
        return menuList;
    }

    public static String filterValue(String input) {
        if(input == null) {
            return input;
        }

        if(input.contains(FOLDERTREE_STR)) {
            input = input.substring(input.indexOf(FOLDERTREE_STR) + FOLDERTREE_STR.length());
        }
        return input;
    }

    public static FolderObj digest(String input) {
        if(input == null) {
            return null;
        }

        Map<String, String> holder = new HashMap<>();
        String [] keyVals = input.split(";");
        for(String keyVal : keyVals) {
            String [] parts = keyVal.split("=");
            holder.put(parts[0], parts[1]);
        }

        FolderObj folderObj = null;
        String childId = null;
        String name = null;
        String type = null;
        String parentId = null;

        for(Map.Entry<String, String> entry : holder.entrySet()) {
            String key = entry.getKey();

            if(key.equals("id")) {
                childId = entry.getValue();
            } else if(key.equals("name")) {
                name = entry.getValue();
            } else if(key.equals("type")) {
                type = entry.getValue();
            } else if(key.equals("parent")) {
                parentId = entry.getValue();
            } 

            folderObj = new FolderObj(childId, parentId, name, type);
        }
        return folderObj;
    }

    public static List<MegaMenuDTO> prepareMenu(List<FolderObj> folderList) {
        // Arrange String corresponds to the Id
        Map<String, MegaMenuDTO> megaMenuMap = new HashMap<>();

        // populate a Map
        for(FolderObj folderObj: folderList){
            MegaMenuDTO mmdChild;
            if(megaMenuMap.containsKey(folderObj.getChildId())){
                mmdChild = megaMenuMap.get(folderObj.getChildId());
            } else{
                mmdChild = new MegaMenuDTO();
                megaMenuMap.put(folderObj.getChildId(),mmdChild);
            }           
            mmdChild.setId(folderObj.getChildId());
            mmdChild.setParentId(folderObj.getParentId());
            mmdChild.setName(folderObj.getName());
            mmdChild.setType(folderObj.getType());

            // ------ Parent ----
            MegaMenuDTO mmdParent;
            if(megaMenuMap.containsKey(folderObj.getParentId())){
                mmdParent = megaMenuMap.get(folderObj.getParentId());
            } else{
                mmdParent = new MegaMenuDTO();
                megaMenuMap.put(folderObj.getParentId(),mmdParent);
            }
            mmdParent.setId(folderObj.getParentId());
            mmdParent.addChildrenItem(mmdChild);
        }

        // Get the root
        List<MegaMenuDTO> menuList = new ArrayList<MegaMenuDTO>(); 
        for(MegaMenuDTO megaMenuDTO : megaMenuMap.values()){
            if(megaMenuDTO.getParentId() == null)
                menuList.add(megaMenuDTO);
        }
        return menuList;
    }

    private static void printMenu(MegaMenuDTO dto, String tabValue) {
        for(MegaMenuDTO childDTO : dto.getChildrenItems()) {
            System.out.println(tabValue + childDTO.getName());
            tabValue = "\t" + tabValue;
            printMenu(childDTO, tabValue);
        }
    }

    private static void captureIdNameMap(MegaMenuDTO dto) throws IOException {
        idNameMap.put(dto.getId(), dto.getName());
        for(MegaMenuDTO childDTO : dto.getChildrenItems()) {
            idNameMap.put(childDTO.getId(), childDTO.getName());
            captureIdNameMap(childDTO);
        }
    }
    private static void printPaths(MegaMenuDTO dto, String name) throws IOException {
        if(dto.getParentId() == null) {
            if(parentChildMap.get("ROOT") == null) {
                List<MegaMenuDTO> parentList = new ArrayList<MegaMenuDTO>();
                parentList.add(dto);
                parentChildMap.put("ROOT", parentList);
            } else {
                List<MegaMenuDTO> parentList = parentChildMap.get("ROOT");
                parentList.add(dto);
                parentChildMap.put("ROOT", parentList);
            }
        }
        for(MegaMenuDTO childDTO : dto.getChildrenItems()) {
            if (parentChildMap.get(childDTO.getParentId()) == null) {
                List<MegaMenuDTO> parentList = new ArrayList<MegaMenuDTO>();
                parentList.add(childDTO);
                parentChildMap.put(childDTO.getParentId(), parentList);
            } else {
                List<MegaMenuDTO> parentList = parentChildMap.get(childDTO.getParentId());
                parentList.add(childDTO);
                parentChildMap.put(childDTO.getParentId(), parentList);
            }
            System.out.println(name + SEPARATOR + childDTO.getName() + ", ParentId : " + childDTO.getParentId());
            createTempRootDir(name + SEPARATOR + childDTO.getName());  
            name = name + SEPARATOR + childDTO.getName();
            printPaths(childDTO, name);
        }
    }

    public static File createTempRootDir(String name) throws IOException {
        final File sysTempDir = new File(System.getProperty(JAVA_IO_TMPDIR));
        File newTempDir = new File(sysTempDir, name);
        if (newTempDir.mkdirs()) {
            return newTempDir;
        } else {
            throw new IOException("Failed to create temp dir named " + newTempDir.getAbsolutePath());
        }
    }

    /**
     * Recursively delete file or directory
     * 
     * @param fileOrDir
     *            the file or dir to delete
     * @return true iff all files are successfully deleted
     */
    public static void recursivelyDelete(File fileOrDir) throws IOException {
        Path directory = Paths.get(fileOrDir.getAbsolutePath());
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
           @Override
           public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
               Files.delete(file);
               return FileVisitResult.CONTINUE;
           }

           @Override
           public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
               Files.delete(dir);
               return FileVisitResult.CONTINUE;
           }
        });
    }
}