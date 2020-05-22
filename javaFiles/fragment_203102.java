String[] input = {"Hello", "my", "Hello", "apple", "Hello"};
    // use hashmap to track the number of strings
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    // use arraylist to track the sequence of the output
    ArrayList<String> list = new ArrayList<String>(); 
    for (String str : input){
        if(map.containsKey(str)){
            map.put(str, map.get(str)+1);
        } else{
            map.put(str, 1);
            list.add(str); // if the string never occurred before, add it to arraylist
        }
    }


    int[] output = new int[map.size()];
    int index = 0;
    for (String str : list){
        output[index] = map.get(str);
        index++;
    }

    for (int i : output){
        System.out.println(i);
    }