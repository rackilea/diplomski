AtomicInteger atomicInteger = new AtomicInteger(0);
Map<Integer, Map<Integer, List<Person>>> collect = personList.stream().collect(Collectors
        .groupingBy(p -> {
                int age = p.getAge() * new Random(10).nextInt();
                atomicInteger.set(age);
                return age;
            }, Collectors.groupingBy(p2 -> p2.getCityCode() + atomicInteger.get())));