void generatePermutations(List<Integer> permutation , int n){
    if(n == -1){
        for(int i = 0 ; i < permutation.size() ; i++)
            System.out.print(matrix[i][permutation.get(i)]);
        System.out.println();
    }else{
        for(int i = 0 ; i <= permutation.size() ; i++){
            permutation.add(i , n);
            generatePermutations(permutation , n - 1);
            permutation.remove(i);
        }
    }
}