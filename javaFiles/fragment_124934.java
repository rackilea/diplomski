public class MyApplet extends Applet
{
   public Object myScriptAction(String arg1, String arg2)
   {
       PrivilegedAction action = new MyAction();
       action.setXXXX();
       Object o = AccessController.doPrivileged(action);
       return o;
   }

   private class MyAction implements PrivilegedAction
   {
       public MyAction() {}
       ...
       public Object run()
       {
           // Do something here, Runtime.exec() or something else
           Runtime.getRuntime().exec(cmdarray, envarray, workingDir);
           return myobj;
       }
   }
}