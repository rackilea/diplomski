@Test
public void shoudSupportRunningCompressedJavaScriptAsMapReduceCommands() {

    createMapReduceData();

    MapReduceResults<ValueObject> results = mongoTemplate.mapReduce(
            "jmr1",
            mapFunction,
            reduceFunction,
            new MapReduceOptions().outputCollection("map_reduce_java_test").outputTypeReplace()
                    .finalizeFunction("function(key,reducedValue){return reducedValue}"), ValueObject.class);

    assertThat(results, is(notNullValue()));

    Map<String, Float> m = copyToMap(results);

    assertEquals(1, m.get("a").intValue());
    assertEquals(2, m.get("b").intValue());
    assertEquals(2, m.get("c").intValue());
    assertEquals(1, m.get("d").intValue());
}