List<MyClass> result;
try(Scanner s=new Scanner(Paths.get("data.txt"))) {

    result = matches(s, "(\\d{1,3}),\\s*\"([^\"]*)\"")
               // MyClass(int id, String text)
    .map(m -> new MyClass(Integer.parseInt(m.group(1)), m.group(2)))
    .collect(Collectors.toList());
}