public static void start(){
    studentNames = getStudents(); //random strings
    keys = getKeys(); //random integers
    map = new HashMap<Integer, String>(magicNumber, (float) 0.7);
    for(int i=0; i< magicNumber; i++){
        String previousValue = map.put(keys[i],studentNames[i]);
        if (previousValue != null) {
            System.out.println(keys[i] + " is a duplicate key");
        }
    }
}