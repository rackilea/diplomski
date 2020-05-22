public class Demo
{
    private final Map<String, Double> suffixFrequencies =
        new TreeMap<String, Double>();

    private String getRandomSuffix()
    {
        final double value = Math.random();
        double accum = 0.0;
        for(final Map.Entry<String, Double> e : suffixFrequencies.entrySet())
        {
            accum += e.getValue();
            if(accum > value)
                return e.getKey();
        }
        throw new AssertionError(); // or something
    }

    public static void main(final String... args)
    {
        final Demo demo = new Demo();
        demo.suffixFrequencies.put("abc", 0.3);  // value in [0.0, 0.3)
        demo.suffixFrequencies.put("def", 0.2);  // value in [0.3, 0.5)
        demo.suffixFrequencies.put("ghi", 0.5);  // value in [0.5, 1.0)

        // Print "abc" approximately three times, "def" approximately twice,
        // and "ghi" approximately five times:
        for(int i = 0; i < 10; ++i)
            System.out.println(demo.getRandomSuffix());
    }
}