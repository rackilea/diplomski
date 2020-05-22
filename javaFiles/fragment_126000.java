Scanner kbd  = new Scanner(System.in);

List<String> input = new ArrayList<>();
while (kbd.hasNextLine())
    input.add(kbd.nextLine());

// after all the input, output the results.
for (String str : input)
    System.out.println(str.toUpperCase());