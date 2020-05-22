List<String> result = ",,,abc,def".codePoints()
            .boxed()
            // .parallel()
            .collect(Collector.of(
                    () -> {
                        List<StringBuilder> inner = new ArrayList<>();
                        inner.add(new StringBuilder());
                        return inner;
                    },
                    (List<StringBuilder> list, Integer character) -> {
                        StringBuilder last = list.get(list.size() - 1);
                        if (character == ',') {
                            list.add(new StringBuilder());
                        } else {
                            last.appendCodePoint(character);
                        }
                    },
                    (left, right) -> {
                        left.get(left.size() - 1).append(right.remove(0));
                        left.addAll(right);
                        return left;
                    },
                    list -> list.stream()
                            .map(StringBuilder::toString)
                            .filter(x -> !x.equals(""))
                            .collect(Collectors.toList())

    ));