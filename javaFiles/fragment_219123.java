Path start = Paths.get("/Users/karan.verma/Music/iTunes/iTunes Media/Music");
        int maxDepth = 15;
        try(Stream<Path> stream = Files.find(start, 
                    maxDepth, 
                    (path, attr) -> String.valueOf(path).endsWith(".mp3"))){

            List<Path> fileName = stream
                    .sorted()
                    .filter(path -> String.valueOf(path).endsWith(".mp3"))
                    .collect(Collectors.toList());

            for(Path p : fileName) {
                Path path = Paths.get("/Users/karan.verma/Desktop/TestCopy/"+p.getFileName());
                Files.copy(p, path,StandardCopyOption.REPLACE_EXISTING);
            }
        }catch(Exception e){
            e.printStackTrace();
        }