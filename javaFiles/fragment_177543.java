List<String> test = Arrays.asList("A","B");
System.out.println("END: " + test.stream()
        .map(s -> {System.out.println("1 " + s); return s; })
        .map(s -> {System.out.println("2 " + s); return s; })
        .reduce("", (acc, s) -> {System.out.println("3 " + s); return acc + s; })
);