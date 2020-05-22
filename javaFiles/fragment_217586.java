class myClass{
    //Declase a Context variable inside your class
    Context x;

    //You implement a constructor for this class that accepts a Context as 
    //a parameter (feel free to add more if you are using a constructor already)
    public myClass(Context applicationContext){
        //Assign the passed value to your local Context
        x = applicationContext;
    }

    //Afterwards, on a different part of your class, you could invoke activity 
    //related methods by using the Context you have 'x'
    public void otherMethod(){
       int myId  = x.getResources().getIdentifier("R.drawable.scoredisplay" + i, "drawable",x.getPackageName());
    }
}