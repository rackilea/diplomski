Entry<List<Integer>, Integer> result = list.stream()
            .collect(Collector.of(
                    () -> new SimpleEntry<>(new ArrayList<>(), 0),
                    (l, x) -> {
                        if (l.getKey().size() < 10) {
                            l.getKey().add(x);
                        }
                        l.setValue(l.getValue() + 1);
                    },
                    (left, right) -> {
                        List<Integer> leftList = left.getKey();
                        List<Integer> rightList = right.getKey();
                        while (leftList.size() < 10 && rightList.size() > 0) {
                            leftList.add(rightList.remove(0));
                        }
                        left.setValue(left.getValue() + right.getValue());
                        return left;
                    }));