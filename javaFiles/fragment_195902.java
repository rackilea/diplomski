return values.stream()
            .map(x -> "'" + x + "'")
            .collect(Collectors.collectingAndThen(Collectors.toList(),
                    list -> {
                        if (list.size() == 1) {
                            return "value" + list.get(0);
                        }
                        if (list.size() > 1) {
                            return String.join(",", list);
                        }
                        return "Nothing found";
                    }));