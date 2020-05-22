List<Integer> list = Arrays.asList(1, 10, 3, 7, 5);
int a = list.stream()
            .peek(num -> System.out.println("will filter " + num))
            .filter(x -> x > 5)
            .findFirst()
            .get();
System.out.println(a);