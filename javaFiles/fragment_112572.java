Timeline.createSequence().beginSequence()
        .push(Tween.to(splash, SpriteAccessor.ALPHA, 0).target(0))
        .push(Tween.to(splash, SpriteAccessor.ALPHA, 2).target(1).setCallback(new TweenCallback() {
            @Override
            public void onEvent(int arg0, BaseTween<?> arg1) {
                SoundManager.PlayIntro();
            }
        }))
        .pushPause(0.5f)
        .push(Tween.to(splash, SpriteAccessor.ALPHA, 2f).target(0)).setCallback(new TweenCallback() {
            @Override
            public void onEvent(int arg0, BaseTween<?> arg1) {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
            }
        })
.start(tweenManager);