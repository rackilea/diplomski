Map<String,Double> mapOfStringAndNumber = new HashMap<>();
mapOfStringAndNumber.put("1",270.5);
mapOfStringAndNumber.put("3",377.5);
mapOfStringAndNumber.put("5",377.5);
String inputString = "1+3+5";
String output = Pattern.compile("\\+")
    .splitAsStream(inputString)
    .map(mapOfStringAndNumber::get)
    .map(d -> Double.toString(d))
    .collect(Collectors.joining("+"));

System.out.println(output);