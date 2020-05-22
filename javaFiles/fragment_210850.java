static void test11()
{
    HashMap<String, Float> map1 = new HashMap<>();
    HashMap<String, Float> map2 = new HashMap<>();

    map1.put("org.openjdk.jmh.samples.JMHSortBenchmark.collectionsSort",(float) 6691.679);
    map1.put("org.openjdk.jmh.samples.JMHSortBenchmark.abcdSort1",(float) 5151.45);
    map1.put("org.openjdk.jmh.samples.JMHSortBenchmark.saasSort",(float) 5454.54);
    map1.put("org.openjdk.jmh.samples.JMHSortBenchmark.xyzSort",(float) 888.22);


    map2.put("org.openjdk.jmh.samples.JMHSortBenchmark.xyzSort", (float) 7448.362);
    map2.put("org.openjdk.jmh.samples.JMHSortBenchmark.abcdSort", (float) 951.5);
    map2.put("org.openjdk.jmh.samples.JMHSortBenchmark.lmnSort", (float) 4454.54);

    for(String key: map1.keySet())
    {
        // use key to search 2nd list, will be null if no matching key found
        Float map2data = map2.get(key);

        if (null == map2data)
        {
            // Current key not found
        }
        else
        {
            Float map1data = map1.get(key);

            // You can do you operations here with matching keys data here
        }
    }
}