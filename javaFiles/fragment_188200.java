String string = "https://docs.google.com/spreadsheets/d/1mrsetjgfZI2BIypz7SGHMOfHGv6kTKTzY0xOM5c6TXY/edit#gid=1842172258";
        String[] parts = string.split("spreadsheets/d/");
        String result;
        if(parts[1].contains("/")){
            String[] parts2 = parts[1].split("/");
            result = parts2[0];
        }
        else{
            result=parts[1];
        }
        System.out.println("hello "+ result);