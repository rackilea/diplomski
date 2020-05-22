private static boolean sameSuperclass(Class<?> leftClass, Class<?> rightClass) {
        if(rightClass.getGenericSuperclass().equals(leftClass.getGenericSuperclass()))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(sameSuperclass(Integer.class,Float.class)); //true
        System.out.println(sameSuperclass(TreeMap.class,ArrayList.class)); //false
    }