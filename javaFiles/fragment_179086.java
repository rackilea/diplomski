String[] arguments = new String[] { "-a", "1", "-b", "2", "-c", "3", "-d", "4", "-e", "5" };
    Map<String, String> map = IntStream.iterate(0, i -> i + 2)
            .limit(arguments.length / 2)
            .parallel()
            .boxed()
            .collect(Collectors.toMap(i -> arguments[i], i -> arguments[i + 1]));

    System.out.println(map); // {-a=1, -b=2, -c=3, -d=4, -e=5}