public static void main(String[] args) {
    // TODO Auto-generated method stub
    try{
        String fname = "PathToFile/a.txt";
        int n = 0;
        Scanner infile = new Scanner(new File(fname));
        while (infile.hasNextInt()){
        n++;
        infile.nextInt();
        }
        Scanner infile2 = new Scanner(new File(fname));
        int [] nums = new int [n];
        for (int i = 0; i<n; i++)
        {
            nums[i] = infile2.nextInt();
        }
        for (int j = 0; j<n-1;j++){
            for (int k = j+1; k<n;k++){
                if (nums[j]+nums[k]==0){
                    int val = nums[j]+nums[k];
                    System.out.println("num["+j+"]"+ " + " +"num["+k+"]"+" = " + nums[j] + " + " + nums[k] + " = " + val);
                }
            }
        }
    }catch(Exception e){
        System.out.println(e);

    }
}