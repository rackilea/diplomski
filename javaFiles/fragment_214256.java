public class MyGenericClass<M, N> {

    private M mType;
    private N nType;

    MyGenericClass (M m, N n){
        this.mType = m;
        this.nType = n;
    }

    public Class<?> getMType(){
        return this.mType.getClass();
    }

    public Class<?> getNType(){
        return this.nType.getClass();
    }

}