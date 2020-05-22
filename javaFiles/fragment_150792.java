import java.util.*;

class Example
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String[] strings = new String[] {
            "one two three",
            "uno due tre",
            "uno dos tres",
            "un deux trois"
        };
        sort(strings, 2); // 2 = third word
        for (String s : strings) {
            System.out.println(s);
        }
    }

    private static void sort(String[] strings, final int index) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2)
            {
                String[] a1 = s1.split(" ");
                String[] a2 = s2.split(" ");
                String word1 = a1.length > index ? a1[index] : "";
                String word2 = a2.length > index ? a2[index] : "";

                return word1.compareTo(word2);
            }
        });
    }
}