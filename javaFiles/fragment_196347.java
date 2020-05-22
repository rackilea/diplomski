Rectangle rect1 = new Rectangle(80, 133, 160, 266, engine.getVertexBufferObjectManager()){
@Override
public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY){
        if(pSceneTouchEvent.getAction() == TouchEvent.ACTION_DOWN){
            //here put what you want to be done after your button was pressed
        }
}
Rectangle rect2 = new Rectangle(240, 133, 160, 266, engine.getVertexBufferObjectManager()){
@Override
public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY){
        if(pSceneTouchEvent.getAction() == TouchEvent.ACTION_DOWN){
            //here put what you want to be done after your button was pressed
        }
}