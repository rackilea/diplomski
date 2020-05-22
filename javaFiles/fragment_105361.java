public static void main(String[] args) {
try {
    Scanner scr = new Scanner(System.in);
    String str = scr.next();
    int a = scr.nextInt();
    int b = scr.nextInt();
    Object obj = Class.forName("PackageName.Sample").newInstance();
    Method method = obj.getClass().getDeclaredMethod(str,int.class,int.class);
    method.invoke(obj,a,b);
} catch (Exception e) {
    e.printStackTrace();
}
}
}