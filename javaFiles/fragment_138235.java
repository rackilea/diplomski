String text = "hello world";
int i;
for(i = 0; i < text.length(); i++){
    System.out.printf("%c", text.charAt(i));
    try{
        Thread.sleep(500);//0.5s pause between characters
    }catch(InterruptedException ex){
        Thread.currentThread().interrupt();
    }
}