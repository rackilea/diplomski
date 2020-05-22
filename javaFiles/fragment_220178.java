public static void main(String[] args) {
    Scanner ins = new Scanner(System.in);
    System.out.println("Enter a String");
    String myData = ins.nextLine();
    ins.close();
    char []  oneDArray = myData.toCharArray();
    int N = 3; // or you can set it by asking the user
    char[][] twoDArray = new char[N][N];
    int size = oneDArray.length;
    boolean isEndReached = false;
    for(int row = 0; row < N ; row++ ){
        for(int col = 0; col < N; col++){
            int index = row*N + col;
            if(index >= size){
                isEndReached = true;
                break;
            }
            twoDArray[row][col] = oneDArray[index];
        }
        if(isEndReached){
            break;
        }
    }
    //printing...
    System.out.print("[");
    for(int row = 0; row < N ; row++ ){
        for(int col = 0; col < N; col++){
            System.out.print(twoDArray[row][col]+" ");
        }
        System.out.println();
    }
    System.out.print("]");
}