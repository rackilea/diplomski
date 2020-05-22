private static List<Integer> parseStringArrayList(List<String> input) {
System.out.println(input.size());
List<Integer> output = new ArrayList<Integer>(input.size());
for (int index = 0; index < input.size(); index++) {
    output.add( Integer.parseInt(input.get(index)));
}
return output;
}