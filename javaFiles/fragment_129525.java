public class TutorielInstance {
    private static TutorialClass instance;
    private static Context context;

    public static synchronized TutorialClass getInstance(){
        if(instance==null){
            instance=new TutorialClass(context);
        }
        return instance;
    }


    public  static  void setContext(Context c){
        context=c;
    }
}