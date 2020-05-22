stage.addListener(new InputListener(){
     @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            //you action here
            stage.removeActor(dialog);
            return true;
        }

});