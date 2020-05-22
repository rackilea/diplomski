Set.of(1, 2, 3, 4)
            .stream()
            .parallel()
            .collect(Collector.of(
                    ArrayList::new,
                    (list, ele) -> {
                        System.out.println("Called accumulator");
                        list.add(ele);
                    },
                    (left, right) -> {
                        System.out.println("Combiner called");
                        left.addAll(right);
                        return left;
                    },
                    new Characteristics[] { Characteristics.CONCURRENT }));