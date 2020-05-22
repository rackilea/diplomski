try {
        List<Path> files = Files.list(Paths.get("path")).filter(path -> Files.isRegularFile(path)).collect(Collectors.toList());            
        int ten_percent = files.size()/10;          
        Collections.shuffle(files); //Randomize         
        files.stream().limit(ten_percent).forEach(source -> copyFile(source, Paths.get("newPAth").resolve(UUID.randomUUID().toString())));

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }