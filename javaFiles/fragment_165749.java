public void methodOne(String string){
    System.out.println(string);
}
public void methodTwo(){
    String string = "This string will be printed by methodOne";
    methodOne(string);
}