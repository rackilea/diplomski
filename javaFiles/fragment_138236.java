String text = "hello world";
int i;
for(i = 1; i <= text.length(); i++){
    g.drawString(text.subString(0, i), x, y);//Where g is your Graphics object and x and y are the coordinates you want to draw at
    try{
        Thread.sleep(500);//0.5s pause between characters
    }catch(InterruptedException ex){
        Thread.currentThread().interrupt();
    }
}