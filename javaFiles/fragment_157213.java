Map<String, Integer[]> aMap = new HashMap<String, Integer[]>();
    aMap.put("Maths", new Integer[]{1,2,3,4});
    Integer[] marks = aMap.get("Maths");
    for(int mark: marks){
        System.out.println(mark);
    }