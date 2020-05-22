List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
String regex = "0123456789";

String listStr = numbers.stream()
                        .map(number -> String.valueOf(number))
                        .collect(toStringJoiner(""));

if (listStr.matches(regex))
    System.out.println("match");
else
    System.out.println("not match");