public static String getThing(){
    String r=new String("ABC");//Created every time the method is invoked.
    return r;
}

private static String sr=new String("ABC");//Static member - one for the whole class.

public static String getStaticThing(){
    return sr;
}

public static void main (String[] args) throws java.lang.Exception
{
    String thing1=getThing();
    String thing2=getThing();
    if(thing1==thing2){
        System.out.println("[1] Same");
    }else{
        System.out.println("[1] Different");
    }

    String thing1s=getStaticThing();
    String thing2s=getStaticThing();
    if(thing1s==thing2s){
        System.out.println("[2] Same");
    }else{
        System.out.println("[2] Different");
    }
}