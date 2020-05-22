@Test
    public void getCsvValuesIntoMap(){
        String csvString ="shirish,vilas,Nikhil";
        Map<Integer,String> expected = new HashMap<Integer,String>(){{
            put(0,"shirish");
            put(1,"vilas");
            put(2,"Nikhil");

        }};
        Map<Integer,String> result = getMapFromCSVString(csvString);
        System.out.println(result);
        assertEquals(expected,result);

    }