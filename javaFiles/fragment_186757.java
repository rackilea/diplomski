public static char setOperend(){    
    @SuppressWarnings("resource") // We don't want to close System.in
    Scanner keyIn = new Scanner(System.in);
    boolean notValid = true;
    char operand = 0;

    do{             
        try{
            operand= keyIn.nextLine().charAt(0);
            notValid = false;
        }catch(InputMismatchException e){
            System.err.print("애러 : 문자가 아닙니다.");
            System.err.print("다시 입력하세요.");
        }
    }while(notValid );

    return operand;
}