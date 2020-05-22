public class classA{
    public classA(Context context){
        this.myContext = context;
    }

    void callMethod(){
        if(isFileValid){

        }else{
            ((Activity)myContext).finish();
        }
    }
}