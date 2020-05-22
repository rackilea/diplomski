String input = "3 52 9+- 2 3 * /";
input = input.replaceAll("([\\+\\-*/])(.)", " $1$2")
             .replaceAll("\\s+", " ");

String[] parts = input.split("(?<=[\+\-*/])|\\s")

System.out.println(Arrays.toString(parts));