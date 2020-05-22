MessageDigest md = null;
    try {
            md = MessageDigest.getInstance("SHA-256");
    }catch(NoSuchAlgorithmException e) {
            System.out.println("Something is wrong");
    }