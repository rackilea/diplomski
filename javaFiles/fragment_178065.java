String s = "\u05d0\u05d5\u05d2\u05e0\u05d3\u05d4";

    try{

        byte[] bytes   = s.getBytes();
        String decoded = new String(bytes); 

        System.out.println(decoded);

    } catch(UnsupportedEncodingException e) {      
        // ...  
    }