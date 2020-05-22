Scanner in = new Scanner (new File ("sudoku1.txt"));
for(int i=0; i<9 && in.hasNextLine(); i++){
    String []nums = in.nextLine().split(",");
    for(int j=0; j<nums.length; j++){
        String n = nums[j].trim();
        grid [i][j] = Integer.parseInt(n);
    }
}
System.out.println(Arrays.deepToString(grid));