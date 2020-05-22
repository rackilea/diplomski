String input = "-12,23,123123";
String[] numbers = input.split(",");
List<Integer> result = new ArrayList<Integer>();
for(String number : numbers){
    result.add(Integer.parseInt(number));
}