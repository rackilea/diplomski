public static boolean makePal(String input){

    HashMap<Character, Integer> map = new HashMap<>();
    int value =1, numberOfOddOccurence = 0;
    //find the number of occurrences
    for(int i=0; i<input.length(); i++){
        char key = input.charAt(i);
        if(!map.containsKey(key)){
            map.put(key, value);
        }else{
            map.put(key, map.get(key)+1);
        }
    }

    //find the number of char with odd counts
    for(Map.Entry<Character, Integer> a : map.entrySet()){
        if(a.getValue()%2==1){
            numberOfOddOccurence++;
        }
    }

    if(numberOfOddOccurence>1)
        return false;
    else{
        char [] charArray = new char[input.length()];
        int cursor = 0;
        for(Map.Entry<Character, Integer> a : map.entrySet()){
            if(a.getValue()%2==0){
                charArray[cursor] = (char)(a.getKey());
                charArray[input.length()-cursor-1] = (char)(a.getKey());
                cursor++;
            }else{
                charArray[(int) Math.ceil(input.length()/2)] = (char) (a.getKey());
            }
        }
        System.out.println(String.valueOf(charArray));
    }

    return true;
}