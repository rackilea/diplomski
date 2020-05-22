String phoneNumber = "1234567890";
        StringBuilder sb = new StringBuilder(phoneNumber)
                                .insert(0,"(")
                                .insert(4,")")
                                .insert(8,"-");
        String output = sb.toString();
        System.out.println(output);