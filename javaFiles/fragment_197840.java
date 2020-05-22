final BiFunction<List<String>, Comparator<String>, List<String>> sort = (values, comparator) -> {
    values.sort(comparator);
    return values;
};

Map<String, List<String>> map = new HashMap<>();
map.put("HR3-A1234", sort.apply(valSetOne(), null)); // first element is min
map.put("HR3-A2345", sort.apply(valSetTwo(), Collections.reverseOrder()));  // first element is max
map.put("HR3-A3456", sort.apply(valSetThree(), null)); // first element is min
map.put("HR3-A4567", sort.apply(valSetFour(), null)); // first element is min

map.forEach((key, values) ->
        System.out.println("Value of " + key + " is " + (values != null && !values.isEmpty() ? values.iterator().next() : null)));