Map<String, String> map = new HashMap<String, String>();
    File folder = new File("F://fileIO/");
    if (folder.isDirectory()) {
        List<File> filesName = Arrays.asList(folder.listFiles());
        Iterator<File> itList = filesName.listIterator();
        File file;
        while (itList.hasNext()) {
            file = itList.next();
            map.put(file.getName(), file.toString());
        }
        System.out.println(map);
    } 
    else {
        System.err.println("something is wrong");
    }