class Junk{
    int value;
    static Junk instance = new Junk();

    static int getJunkStuff(){
        return instance.value;
    }
    static void setInstance(Junk j){
        instance = j;
    }
}