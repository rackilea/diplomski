public void printTriangle(String input) {
        String tmp = input.substring(1);//Take the suffix
        StringBuilder builder = new StringBuilder(tmp);
        builder = builder.reverse().append(input);//Reverse, then append it
        String line = builder.toString();//This is the last line
        for(int i = 0; i < input.length(); i++){
            for(int j = 0; j < line.length(); j++){
                //Print the last line, or those that have distance equals i to the center of the last line
                if(i + 1 == input.length() || Math.abs(j - line.length()/2) == i){
                    System.out.print(line.charAt(j));
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }