public static String readId() {
    String id = "";
    while(true){
        id = leer.next();
        try{
            Integer.parseInt(id.substring(0,8));
        }catch(InputMismatchException e){
            System.out.println("Invalid Input");
            continue;
        }
        if(id.length() != 9)continue;
        if(Character.isLetter(id.chatAt(8)))break;
    }
    return id;
}