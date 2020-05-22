IEntityModifierListener listener = new IEntityModifierListener() {
        GameScene  gScene = null;
        @Override
        public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
            attachChild(new Text(400, 150, resourcesManager.font, "Loading...", vbom));
            // load resources here
            gScene = new GameScene();
            gScene.LoadResources();

        }                                                                                                             
        @Override
        public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
            // set Scene  here
            gScene.loadScene();

        }
    };
    playButton.registerEntityModifier(new DelayModifier(4, listener));