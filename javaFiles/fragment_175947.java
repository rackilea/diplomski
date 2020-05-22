public static void populateMatrix(int[] s){
    File input = new File("set2.txt");
    int value;

    try{
    Scanner inf = new Scanner(input);

    for(int i = 0; i < s.length ;){
        value = inf.nextInt();
        if(value <= D){
            s[i] = value;
            i++;
        }
    }//for
    }//try

    catch(IOException e){
        e.printStackTrace();
    }

}//PopulateMatrix