public static void main(String[] args) {

        int[] array1 = { 1, 2, 3, 4, 5 };   

        String[][] array2 = { { "open", "1", "2", "7" }, { "3", "3", "4", "r" } ,{ "close", "3", "4", "ff" },{ "open", "3", "4", "close" },{ "55", "3", "4", "f" },{ "close", "3", "4", "rr" }};

        HashMap<Integer, List<String>> hm= new HashMap<Integer, List<String>>();

        for(int i=0;i<array1.length;i++){
            List<String> list = new ArrayList<String>();
            for(String str : array2[i]){
                list.add(str);
            }
            hm.put(i, list);
        }

        for(Integer intKey : hm.keySet()){
            System.out.println(intKey + " : " + hm.get(intKey));
        }
    }