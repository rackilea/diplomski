for(int i = 0; i < str.length(); i++) {
            for (int spacesCount = 0; spacesCount<i; spacesCount++){
                System.out.print(" ");
            }
            System.out.println(str.charAt(i));
        }