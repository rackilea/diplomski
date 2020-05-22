for (int i = 0; i < charen.length(); i++) {
        System.out.println(encry);
        int temp = Integer.parseInt(idolnum());
        System.out.println("" + temp + " " + (int) encrypt.charAt(i));
        temp = (int) encrypt.charAt(i) + temp;
        encrypted = encrypted + (char) temp;
        // System.out.println(encrypted.charAt(i));
    }