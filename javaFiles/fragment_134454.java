private static void findCombinations(int[][] matrix, int row, Integer[] currentArray) {
    if(row == matrix.length){
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(currentArray));
        result.add(list);
        return;
    }
    int cols = matrix[0].length;
    for(int i=0;i< cols;i++){
        currentArray[row]=matrix[row][i];
        findCombinations(matrix,row+1,currentArray);
    }
}