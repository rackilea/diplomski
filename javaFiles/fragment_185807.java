Form my Form = new Form ();     
int color = 0xffffff;
Font materialFontBack = Font.createTrueTypeFont("fontello-back", "fontello-back.ttf");           
FontImage imageBack = FontImage.createFixed("\ue800", materialFontBack, color, 40, 40);


Command back = new Command("Back") {

     @Override
     public void actionPerformed(ActionEvent evt) {
         formStart.showBack();
     }
};

myForm.getToolbar().setBackCommand(back);

ToolBar myToolbar = myForm.getToolbar();
Button buttonToolbar = myToolbar.findCommandComponent(back);
buttonToolbar.setIcon(imageBack);