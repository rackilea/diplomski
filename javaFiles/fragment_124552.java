public void start() throws IOException {
    URL url = getClass().getResource("res/base.xml");
    if (url != null) {
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        System.out.println("File exist!");

        try(InputStream result = url.openStream()) {
            try(Scanner scn = new Scanner(result)) {
                while(scn.hasNext()) {
                    System.out.println(scn.next());
                }
            }
        }
    } else {
        System.out.println("Not working! :(");    
    }
}