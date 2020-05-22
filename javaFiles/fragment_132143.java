public static MyComplexObject Load(Context context){
    try{
        FileInputStream fis = context.getApplication().openFileInput("player1.data");
        ObjectInputStream is = new ObjectInputStream(fis);
        MyComplexObject Game = (MyComplexObject) is.readObject();
        is.close();
        fis.close();
        return Game;
    }catch (Exception e){
        Log.e("Load", "creating new game - \n" + e.toString());
        MyComplexObject NewGame = MyComplexObject();
        return NewGame;
    }
}