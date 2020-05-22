String in = "!abc3@";
        String out = in;
        if( (!in.isEmpty()) && (!Character.isLetterOrDigit(in.charAt(0))) )
            out = in.substring(1, in.length());
        if( (!out.isEmpty()) && (!Character.isLetterOrDigit(out.charAt(out.length() - 1))) )
            out = out.substring(0, out.length() - 1);
        System.out.println("result: " + out);