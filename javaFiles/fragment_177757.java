String str = "ha2iwea435";
String[] numbers = str.split("[^\\d]");

List<String> list = new ArrayList<> (Arrays.asList(numbers));
list.removeAll(Arrays.asList(""));
System.out.println("numbers = " + list); // numbers = [2, 435]