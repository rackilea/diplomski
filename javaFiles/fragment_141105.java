public void UpdateAndDraw(float delta){
    for(int i = 0; i < mPlatforms.size(); i++){
        mPlatforms.get(i).Update(delta);
        mPlatforms.get(i).GetTexture().draw(batcher);
    }
}