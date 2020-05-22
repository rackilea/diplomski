List<Integer> result = IntStream.iterate(0, i -> i + 1)
            .takeWhile(i -> {
                String arr[] = { "A", "B", "C", "D", "E", "F", "G", "H", "R", "T" };
                List<String> list = new ArrayList<>();
                Arrays.stream(arr)
                        .parallel()
                        .peek(list::add)
                        .forEach(x -> {
                        });

                if (list.contains(null)) {
                    System.out.println("It took " + i + " steps to see a null");
                    return false;
                }

                return true;
            })
            .boxed()
            .collect(Collectors.toList());