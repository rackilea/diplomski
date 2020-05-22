if(Password.equalsIgnorecase(actualPass)){

        System.out.println("They Matched!");
        loggedIn.setVisibility(View.VISIBLE);
        CreateUser.setVisibility(View.GONE);
        loginBtt.setText("Create User");

    }else if(Password.equalsIgnorecase(actualPass.toString())){

        System.out.println("Second Match");

    }else if(Password.equalsIgnorecase(actualPass)){

        System.out.println("Third Match");

    }else if(!Password.equalsIgnorecase(actualPass)){

    System.out.println("Wrong");
    incorrectPassword();
    System.out.println(Password);
    System.out.println(actualPass);

    }