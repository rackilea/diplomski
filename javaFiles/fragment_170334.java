String text = "0123456789abcdefghij";

List<String> parts = new ArrayList<String>();
parts.add(text.substring(0, 5));
parts.add(text.substring(3, 7));
parts.add(text.substring(9, 13));
parts.add(text.substring(18, 20));

System.out.println(parts); // prints "[01234, 3456, 9abc, ij]"

String[] partsArray = parts.toArray(new String[0]);