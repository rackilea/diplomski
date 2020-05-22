String example = "01OCT12 14:26";
        String pattern = "^(\\d{2})(?:OCT|NOV)(\\d{2}) (\\d{1,2}):(\\d{2})$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(example);

        if (m.find()) 
        {
            //prints example
            System.out.println(m.group());

            System.out.println(m.group(1)); //prints 01
            System.out.println(m.group(2)); //prints 12
            System.out.println(m.group(3)); //prints 14
            System.out.println(m.group(4)); //prints 26
        }