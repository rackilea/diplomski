String in = Integer.toString(input.nextInt());
    String [] tall = {"null", "en" , "to", "tre", "fire" , "fem", "seks", "syv", "åtte", "ni", "ti"};       

    for(char c : in.toCharArray()){
        int i = (int) (c-'0');
        for (int j = 0; j<tall.length; j++) {
            if(i == j){
                System.out.print (tall[j] + " ");
            }
        }
    }