private float timeSeconds = 0f;
        private float period = 1f;

        public void render() {
            //Execute handleEvent each 1 second
            timeSeconds +=Gdx.graphics.getRawDeltaTime();
            if(timeSeconds > period){
                timeSeconds-=period;
                handleEvent();
            }

            [...]

        }

        public void handleEvent() {
             [...]
        }