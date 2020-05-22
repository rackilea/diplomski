public class FruitPool extends GenericPool<Sprite> {
// ===========================================================
// Constants          
// ===========================================================

// ===========================================================          
// Fields         
// =========================================================== 
private final TextureRegion mTextureRegion;
// ===========================================================          
// Constructors          
// =========================================================== 
public FruitPool(final TextureRegion pFruitTextureRegion) {
    this.mTextureRegion = pFruitTextureRegion;
}
// ===========================================================          
// Getter & Setter          
// =========================================================== 

// ===========================================================          
// Methods for/from SuperClass/Interfaces          
// ===========================================================  
@Override
protected Sprite onAllocatePoolItem() {
    return new Sprite(0, 0, this.mTextureRegion);
}
@Override
protected void onHandleObtainItem(final Sprite pItem) {
    pItem.reset();
}
@Override
protected void onHandleRecycleItem(final Sprite pItem) {
    pItem.setVisible(false);
    pItem.setIgnoreUpdate(true);
}
// ===========================================================          
// Methods          
// ===========================================================  

// ===========================================================          
// Inner and Anonymous Classes          
// ===========================================================  
}