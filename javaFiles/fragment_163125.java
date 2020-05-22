while(readFile.hasNext()){
    libraryLogin_class login = new libraryLogin_class();

    loginObject = readFile.nextLine();
    String[] values = loginObject.split(",");
    login.setUsername(values[0]);
    login.setPassword(values[1]);
    // use login
}