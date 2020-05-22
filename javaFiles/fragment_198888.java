public static void main(String[] args) {
    Scanner get = new Scanner(System.in);
    int num;
    System.out.println("User please enter a number of your choice : ");
    num = get.nextInt();

    for(int x = 1 ; x < num ; x++){
    String number = ""+ x ;
    int sum = 0 ;

    for(int i = 0 ; i < number.length() ; i ++ ){
         sum +=number.charAt(i)-'0' ; }

    if(x % 3 == 0 && sum <= 5){
       System.out.println(x) ; }

    sum = 0 ; 
    }
   }