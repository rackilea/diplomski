@Test
public void test(){

    // Basic test data
    Order today1 = new Order(LocalDate.now(),1);
    Order today2 = new Order(LocalDate.now(),2);
    Order today3 = new Order(LocalDate.now(),5);
    Order tomorrow1 = new Order(LocalDate.now().plusDays(1),2);
    Order yesterday1 = new Order(LocalDate.now().minusDays(1),5);
    Order yesterday2 = new Order(LocalDate.now().minusDays(1),4);
    List<Order> list = Lists.newArrayList(today1,today2,today3,tomorrow1,yesterday1,yesterday2);

    // Setup multimap and fill it with Orders
    ListMultimap<LocalDate, Integer> mm = ArrayListMultimap.create();
    for(Order o : list){
        mm.put(o.date,o.value);
    }

    // At this point, all you need to do is, for each date "bucket", sum up all values.
    Map<LocalDate, Integer> resultMap = Maps.newHashMap();
    for(LocalDate d : mm.keySet()){
        List<Integer> values = mm.get(d);
        int valuesSum = 0;
        for(int i : values){
            valuesSum += i;
        }
        resultMap.put(d,valuesSum);
    }

    /*
    * Result map should contain:
    * today -> 8
    * tomorrow -> 2
    * yesterday -> 9
    * */
    assertThat(resultMap.size(), is(3));
    assertThat(resultMap.get(LocalDate.now()), is(8));
    assertThat(resultMap.get(LocalDate.now().minusDays(1)), is(9));
    assertThat(resultMap.get(LocalDate.now().plusDays(1)), is(2));
}