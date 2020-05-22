public interface MyJnaInterface;
public interface MyJnaInterfaceWin implements MyJnaInterface; // this has the WinMethod method

...

    private static MyJnaInterface INSTANCE;

    static{
        if(SystemUtils.IS_OS_LINUX){
            INSTANCE=(MyJnaInterface) Native.loadLibrary("MyLibrary",MyJnaInterface.class);
        }else{
            INSTANCE=(MyJnaInterfaceWin) Native.loadLibrary("MyLibrary",MyJnaInterfaceWin.class);
        }
    }


...

public static void WinMethod(){
            if(!SystemUtils.IS_OS_LINUX) ((MyJnaInterfaceWin)INSTANCE).WinMethod());
        }