public static void main(String[] args)
{
    Map<String, Map<String, Double>> map1 = new HashMap<>();
    Map<String, Double> inner11 = new HashMap<>();
    inner11.put("2016-10-02", 10.0);
    inner11.put("2016-10-03", 20.0);
    inner11.put("2016-10-04", 30.0);
    map1.put("ID1", inner11);
    Map<String, Double> inner12 = new HashMap<>();
    inner12.put("2016-10-02", 1.00);
    inner12.put("2016-10-03", 2.00);
    inner12.put("2016-10-04", 3.00);
    map1.put("ID2", inner12);

    Map<String, Map<String, Double>> map2 = new HashMap<>();
    Map<String, Double> inner21 = new HashMap<>();
    inner21.put("2016-10-02", 2.00);
    inner21.put("2016-10-03", 3.00);
    map2.put("ID1", inner21);
    Map<String, Double> inner22 = new HashMap<>();
    inner22.put("2016-10-02", 1.00);
    inner22.put("2016-10-03", 2.00);
    inner22.put("2016-10-04", 3.00);
    map2.put("ID3", inner22);

    System.out.println(method(map1, map2));
}