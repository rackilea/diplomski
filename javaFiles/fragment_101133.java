if (rs.getString(2).equals(validate.getUserPassword())) {
        System.out.println("User and Password Match");
        returnValue =true;
                    } else {
        System.out.println("No User Or Password Match");
         returnValue =false;
                    }