class Leaker 
{
    public static Object leakedObj;
}

class MyActivity extends Activity
{
     public class MyInnerClass { ... }

     void onCreate(Bundle savedState) 
     {
        Leaker.leakedObj = new MyInnerClass();
        //The activity now won't be GCed until Leaker.leakedObj is cleared.          
     }
}