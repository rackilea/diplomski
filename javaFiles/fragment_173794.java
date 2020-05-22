public Scene onLoadScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());

        this.mScene = new Scene();
        for(int i = 0; i < LAYER_COUNT; i++) {
            this.mScene.attachChild(new Entity());
    }