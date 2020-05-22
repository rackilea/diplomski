Pattern pattern1 = Pattern.compile("^[a-zA-Z1-9][a-zA-Z1-9_\\.-]{2,64}$");
            Pattern pattern2 = Pattern.compile("[^\\.-]$");
            Matcher m1 = pattern1.matcher(input);
            Matcher m2 = pattern1.matcher(input);
            if(m1.find() && m2.find()) {
                System.out.println("found");
            }