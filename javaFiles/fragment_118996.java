public static void main(String[] args) throws IOException {
        //        Path fileName = Paths.get(args[0]);
        //        String pathZip = args[1];
        Path fileName = Paths.get("C:\\Users\\dell\\Desktop\\addfile.txt");
            String pathZip = "C:\\Users\\dell\\Desktop\\test.zip";
        Map<String, byte[]> zipEntryMap = addFilesInMap(pathZip);
        FileOutputStream fileOutputStream =  new FileOutputStream(pathZip);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        zipEntryMap.forEach((zipEntryName, bytes) -> {
            System.out.println(zipEntryName+" "+bytes.toString());
            try {
                containAndSaveSameFiles(pathZip, bytes, zipEntryName, zipOutputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        saveFileInArchive(fileName, pathZip,zipOutputStream);
        zipOutputStream.close();
        fileOutputStream.close();
    }
    private static Map<String, byte[]> addFilesInMap(String pathZip) throws IOException {
        Map<String, byte[]> zipEntryMap = new HashMap<>();
        FileInputStream fileInputStream = new FileInputStream(pathZip);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        ZipEntry zipEntry;
        while((zipEntry = zipInputStream.getNextEntry())!= null){
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream builder = new ByteArrayOutputStream();
            int end;
            while((end = zipInputStream.read(buffer)) > 0){
                builder.write(buffer, 0, end);
            }
            zipEntryMap.put(zipEntry.getName(), builder.toByteArray());
        }
        return zipEntryMap;
    }
    private static void containAndSaveSameFiles(String pathZip, byte[] bytes, String zipEntryName, ZipOutputStream zipOutputStream) throws Exception{
//        ByteArrayOutputStream readBytes = new ByteArrayOutputStream();
        ZipEntry zipEntry2 = new ZipEntry(zipEntryName);
        zipEntry2.setSize(bytes.length);
        zipOutputStream.putNextEntry(new ZipEntry(zipEntryName));
        zipOutputStream.write(bytes);
    }
    private static void saveFileInArchive(Path fileToBeAdded, String pathToArchive, ZipOutputStream zipOutputStream) throws IOException, IOException {
        zipOutputStream.putNextEntry(new ZipEntry("new/"+fileToBeAdded.getFileName()));
        Files.copy(fileToBeAdded, zipOutputStream);
    }