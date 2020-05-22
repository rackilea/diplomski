String s = "4x+6y+7z";

        //some fields will be null, because we don't know how many 
        //constants will be there, same goes for variables array 
        String[] constants = new String[s.length()];

        String[] variables = new String[s.length()]; 

        //loop through the string, length of string             
        for(int i =0, j = 0, k=0 ; i< s.length();i++) {
            if(Character.isDigit(s.charAt(i))) {
                //the character at location ith location of string is Digit
                constants[j] = String.valueOf(s.charAt(i));
                j++; 
            } else if(Character.isAlphabetic(s.charAt(i))) {
                 //the character at location ith location of string is Alphabet
                variables[k] = String.valueOf(s.charAt(i)); 
                k++; 
            }
        }

        System.out.println(Arrays.toString(constants));
        System.out.println(Arrays.toString(variables));