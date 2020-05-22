package com.bob;
public class Test
{
    public enum Letters {
        A, B, C, D, E
    }

    public enum Numbers {
        ONE, TWO, THREE, FOUR, FIVE
    }

    public static void main(String [] args) throws Exception 
    {

        System.out.println("Enter in you choice, letters (Letters) or numbers(Numbers)");
        String entry = "";
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        entry = reader.readLine();

        Class<Enum<?>> clazz = (Class<Enum<?>>)Class.forName("com.bob.Test$" + entry);

        for (Enum<?> x : clazz.getEnumConstants())
        {
            System.out.println(x);
        }

    }
}