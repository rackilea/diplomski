List<? extends Number> doubles = new ArrayList<Double>();
List<Number> nums = (List<Number>) doubles;

nums.add(new Integer(5));    // no compiler complaints here...

// doubles now contains an Integer value!