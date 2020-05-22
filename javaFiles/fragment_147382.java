void draw(int mouseX, int mouseY){
  if(mouseX<=5)
  {
    try{
        Robot bot = new Robot();
        bot.mouseMove(420, mouseY);
    }catch (AWTException e){
        e.printStackTrace();
    }
  }
}