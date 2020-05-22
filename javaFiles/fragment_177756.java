String str = "ha2iwea435";
String[] numbers = str.split("[^\\d]");

List<Integer> list = new ArrayList<> ();
for (String number : numbers) {
    if (!number.isEmpty()) list.add(Integer.parseInt(number));
}
System.out.println("numbers = " + list); // numbers = [2, 435]