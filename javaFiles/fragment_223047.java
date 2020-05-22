private static List<List<Integer>> generateCombinations(int[] arr){
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        int prev2 = 1,prev1 = 1;

        for(int i=0;i<arr.length;++i){
             //individual
            List<Integer> l = new ArrayList<>();
            l.add(arr[i]);
            combs.add(l);   

            if(i < 2){ // since these are base cases for our fibonacci sequence
                continue;
            }

            int size = prev1 + prev2 - 1; 

            for(int j=0;j<size;++j){
                List<Integer> new_list = new ArrayList<>(combs.get(j));
                new_list.add(arr[i]);
                combs.add(new_list);
            }           

            prev1 = prev1 + prev2;
            prev2 = prev1 - prev2;
        }        

        return combs;
    }