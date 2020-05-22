String username = System.getProperty("user.name");
File myGamesDir = new File(System.getProperty("user.home"), "my-games");
File typeKingDir = new File(myGamesDir, "type-king");
File userDir = new File(typeKingDir, username);
boolean userSuccess = userDir.mkdirs();
if(userSuccess){
    System.out.println("Directory " + username + " created.");
    File f = new File(userDir, "test.txt");
    if(!f.exists()){
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not create user's file.");
        }
    }