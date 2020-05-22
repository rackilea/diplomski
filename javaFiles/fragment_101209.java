public ButtonSprite(final float pX, final float pY, final ITiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final OnClickListener pOnClickListener) {
    super(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager);

    this.mOnClickListener = pOnClickListener;
    this.mStateCount = pTiledTextureRegion.getTileCount();

    switch(this.mStateCount) {
        case 1:
            Debug.w("No " + ITextureRegion.class.getSimpleName() + " supplied for " + State.class.getSimpleName() + "." + State.PRESSED + ".");
        case 2:
            Debug.w("No " + ITextureRegion.class.getSimpleName() + " supplied for " + State.class.getSimpleName() + "." + State.DISABLED + ".");
            break;
        case 3:
            break;
        default:
            throw new IllegalArgumentException("The supplied " + ITiledTextureRegion.class.getSimpleName() + " has an unexpected amount of states: '" + this.mStateCount + "'.");
    }

    this.changeState(State.NORMAL);
}