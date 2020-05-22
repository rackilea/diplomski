File file = new File();
    File[] files = file.listFiles();
    for (int i = 0; i < files.length; i++) 
        try {
            {
                System.out.println("Do stuff");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }