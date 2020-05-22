Gdx.input.setInputProcessor(new InputAdapter() {
        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            if(leftRect.contains(screenX, screenY)){
                //move player left
                return true;
            }

            if(rightRect.contains(screenX, screenY)){
                //move player right
                return true;
            }

            return false;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            if(jumpRect.contains(screenX, screenY)){
                //make player jump
                return true;
            }
            return false;
        }
    });