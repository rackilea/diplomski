String oldPassword = "Angel173MN";
    String newPassword = "Tomato47nge";
    for (int i = 0; i < oldPassword.length() - 2; i++) {
        String sub = oldPassword.substring(i, i + 3);
        if (newPassword.contains(sub)) {
            System.out.println("Substring " + sub + " is part of both passwords");
        }
    }