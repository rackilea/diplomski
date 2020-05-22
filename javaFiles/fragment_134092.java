public enum Type {

    A(1, true), B(1, true), C(1, true), D(1, true), E(1, false);

    private int poolSize;
    private boolean isHandlerEnabled;

    Type(int poolSize, boolean isHandlerEnabled) {
        this.poolSize = poolSize;
        this.isHandlerEnabled = isHandlerEnabled;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public boolean isHandlerEnabled() {
        return isHandlerEnabled;
    }
    public createHandler(){
       if (!isHandlerEnabled){
           return null;
       }
       return new Handler(this, poolSize);
    }    
}