public Scene onLoadScene(float PosX,float PosY) {//PosX,PosY is float you can take as per your choice
             this.mScene = new Scene();
             spritePic1.setPosition((int)PosX- textRegPic1.getWidth()/2,(int) PosY- textRegPic1.getHeight()/2);

return this.mScene;
    }