public static void main(String args[]){
    Scanner sc= new Scanner (System.in);
    System.out.println("Enter the string");
    String str=sc.next();
    char arr[][]=new char[5][5];
    char a[]=str.toCharArray();
    int l=a.length;
    int k=0;
    for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
            if(k != l) {
              arr[i][j]=a[k];// this is the place where the error is occurred.
              k++;
            }else {
                break;
            }
        }
    }
    for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
}