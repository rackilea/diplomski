class output{

    UnserInfo userInfo = new UserInfo();        <<<----------------

    public void outputDetails(){
        int i=1;

        for(User m : userInfo.getUser()){       <<<-----------------
            System.out.println("Name: "+m.name);

            System.out.println("\nPassword: "+m.password);

            i++;
        } 
        System.out.println();
    }
}