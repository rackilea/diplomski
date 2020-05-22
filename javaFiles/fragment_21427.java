public aspect CurrentTimeInMillisMethodCallChanger {

    long around(): 
       call(public static native long java.lang.System.currentTimeMillis()) 
       && within(user.code.base.pckg.*) {
         return 0; //provide your own implementation returning a long
    }
}