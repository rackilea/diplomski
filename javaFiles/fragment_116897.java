private static final float SUBTITLE_FADE_DELAY = 0.5f;

float fade2 = Interpolation.fade.apply((fadeElapsed-SUBTITLE_FADE_DELAY) / FADE_IN_TIME);

//...

batch.begin();
font.setScale(1.0f);
font.setColor(1, 1, 1, fade);
font.draw(batch, title, 100, 600);
font.setScale(0.5f);
font.setColor(1, 1, 1, fade2);
font.draw(batch, subTitle, 200, 500);
batch.end();