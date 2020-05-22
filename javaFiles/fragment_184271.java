Sprite Next=new Sprite(x-48/factor, y+30/factor, 96/factor, 60/factor,LoadAssets.WinMenuNextTextureRegion){
@Override
public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
if(pSceneTouchEvent.isActionUp()){
pEngine.setScene(GamePlayScene.CreateTheGamePlayScene(context,pEngine,camera_width, camera_height,GamePlayScene.LevelNumber+1));
}
return true;
}};