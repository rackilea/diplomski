try {
        File f = new File("Merged file.xls");
        if (!f.exists()) {
            System.out.println("File does not exist");
            if (!f.createNewFile())
                System.out.println("File cannot be created");
            else
                System.out.println("File created");
        } else {
            System.out.println("File exists");
            if(!f.canRead())
                System.out.println("Error in reading. Need permission");
            if(!f.canWrite())
                System.out.println("Error in writing. Need permission");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}