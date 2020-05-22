public final class Scale5
{
     public static final Scale5 GOOD = new Scale5();
     public static final Scale5 BETTER = new Scale5();
     public static final Scale5 BEST = new Scale5();

     static Scale5 s = GOOD;//works because GOOD is initialized first;
     Scale5 ss = GOOD;//doesn't work because in order to initialize GOOD, 
                      //ss must be assigned an object that is not yet initialized;
}