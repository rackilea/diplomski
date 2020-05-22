public class ThisExample {
    private int wrongExample = 0;
    private int thisExample = 0;

    public ThisExample (int wrongExample, int thisExample){
        wrongExample = wrongExample;
        this.thisExample = thisExample; 
    }

    public int getThisExample(){
        return thisExample;
    }
    public int getWrongExample(){
        return wrongExample;
    }
}