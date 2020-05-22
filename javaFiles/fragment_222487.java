package test;

import java.lang.reflect.Field;

public class BreakMath {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {

        Class<?> integerCache = Class.forName("java.lang.Integer$IntegerCache");
        Field field = integerCache.getDeclaredField("cache");
        field.setAccessible(true);
        Integer[] cache = (Integer[]) field.get(null);
        cache[1 + 128] = 2;
        System.out.println(1 + 1);
        System.out.println(1 + Integer.valueOf(1));
        System.out.println(Integer.valueOf(1) + Integer.valueOf(1));
    }
}