DatabaseHandler d = new DatabaseHandler(this);
        HashMap<String, String> getdetails = d.getUserDetails();
        String name = getdetails.get("name");
        String email = getdetails.get("email");
        String uid = getdetails.get("uid");
        String created_at = getdetails.get("created_at");

        System.out.println("Name-->" + name);
        System.out.println("Email-->" + email);
        System.out.println("UID-->" + uid);
        System.out.println("Created At-->" + created_at);