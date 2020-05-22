class P{
    Object name = new Date();
}

public static void main(String[] args) {
    P p = new P();   
    System.out.println(p.name);
    System.out.println(((Cls)p.name).getClass());

    test1(p);
    test2(p);
}


public static void test1(P k){
    System.out.println(k.name.getClass());
}

public static void test2(P k){
    System.out.println(((Cls)k.name).getClass());
}