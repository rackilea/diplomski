class MyObject{

    public static void myMethod(MyObject object){
        //Do something
    }

    public MyObject(){
        myMethod(this);
    }

}