public static void main(String[] args) {

        int[] array1 = { 1, 2, 3, 4, 5 };   

        String[][] array2 = { { "open", "1", "2", "7" }, { "3", "3", "4", "r" } ,{ "close", "3", "4", "ff" },{ "open", "3", "4", "close" },{ "55", "3", "4", "f" },{ "close", "3", "4", "rr" }};

        HashMap<Integer, List<List<String>>> hm= new HashMap<Integer, List<List<String>>>();


        int savePoint = 0;
        boolean flag = false;
        for(int i=0;i<array1.length;i++){


            List<List<String>> listSet = new ArrayList<List<String>>();

            for(int j = savePoint ; j < array2.length ; j++){
                List<String> list = new ArrayList<String>();

                savePoint++;

                for(String str : array2[j]){
                    list.add(str);
                }

                flag = true;
                listSet.add(list);

                if(list.get(0).contains("close")){

                    break;
                }

            }

            if(flag){
                hm.put(array1[i], listSet);
                flag= false;
            }
        }

        for(Integer intKey : hm.keySet()){
            System.out.println(intKey + " : " + hm.get(intKey));
        }
    }