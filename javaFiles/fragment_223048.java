public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        List<List<Integer>> result = generateCombinations(arr);
        int size = result.size();
        for(int i=0;i<size;++i){
            System.out.println(result.get(i).toString());
        }
    }