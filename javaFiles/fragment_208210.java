public static  ArrayList<String> enrichValues(ArrayList<String> values){
    ArrayList<String> array = new ArrayList<String>();

    for (String str : values){ //For each string

        StringBuilder copy = new StringBuilder();

        for (char c : str.toCharArray()) {//For each char

            copy.append(c);

            if(Character.isLetter(c) && Character.isUpperCase(c)){
                copy.append(Character.toLowerCase(c));
            }   
        }            
        array.add(copy.toString());
    }        
    return array;
}