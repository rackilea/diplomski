D:\home\ray\dev\indigoapps\so8032067enumimpl\bin>javap -c Color
Compiled from "Color.java"
public final class Color extends java.lang.Enum{
public static final Color r;

public static final Color g;

public static final Color b;

final int rgb;

static {};
  Code:
   0:   new     #1; //class Color
   3:   dup
   4:   ldc     #16; //String r
   6:   iconst_0
   7:   ldc     #17; //int 16711680
   9:   invokespecial   #18; //Method "<init>":(Ljava/lang/String;II)V
   12:  putstatic       #22; //Field r:LColor;
   15:  new     #1; //class Color
   18:  dup
   19:  ldc     #24; //String g
   21:  iconst_1
   22:  ldc     #25; //int 65280
   24:  invokespecial   #18; //Method "<init>":(Ljava/lang/String;II)V
   27:  putstatic       #26; //Field g:LColor;
   30:  new     #1; //class Color
   33:  dup
   34:  ldc     #28; //String b
   36:  iconst_2
   37:  sipush  255
   40:  invokespecial   #18; //Method "<init>":(Ljava/lang/String;II)V
   43:  putstatic       #29; //Field b:LColor;
   46:  iconst_3
   47:  anewarray       #1; //class Color
   50:  dup
   51:  iconst_0
   52:  getstatic       #22; //Field r:LColor;
   55:  aastore
   56:  dup
   57:  iconst_1
   58:  getstatic       #26; //Field g:LColor;
   61:  aastore
   62:  dup
   63:  iconst_2
   64:  getstatic       #29; //Field b:LColor;
   67:  aastore
   68:  putstatic       #31; //Field ENUM$VALUES:[LColor;
   71:  return

public static Color[] values();
  Code:
   0:   getstatic       #31; //Field ENUM$VALUES:[LColor;
   3:   dup
   4:   astore_0
   5:   iconst_0
   6:   aload_0
   7:   arraylength
   8:   dup
   9:   istore_1
   10:  anewarray       #1; //class Color
   13:  dup
   14:  astore_2
   15:  iconst_0
   16:  iload_1
   17:  invokestatic    #43; //Method java/lang/System.arraycopy:(Ljava/lang/Obj
ect;ILjava/lang/Object;II)V
   20:  aload_2
   21:  areturn

public static Color valueOf(java.lang.String);
  Code:
   0:   ldc     #1; //class Color
   2:   aload_0
   3:   invokestatic    #51; //Method java/lang/Enum.valueOf:(Ljava/lang/Class;L
java/lang/String;)Ljava/lang/Enum;
   6:   checkcast       #1; //class Color
   9:   areturn

}