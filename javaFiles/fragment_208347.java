private List<MultipartFile> file;
String saveDirectory = System.getProperty("catalina.home");
    List<MultipartFile> ListaFajlova = File.getFile();
    List<String> fileNames = new ArrayList<String>();

    if (null != ListaFajlova && ListaFajlova.size() > 0) {
        for (MultipartFile multipartFile : ListaFajlova) {

            String fileName = multipartFile.getOriginalFilename();
            if (!"".equalsIgnoreCase(fileName)) {            
                multipartFile
                        .transferTo(new File(saveDirectory + File.separator+fileName));
                fileNames.add(fileName);
            }
        }
    }