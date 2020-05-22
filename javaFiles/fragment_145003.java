List<Map<String, String>> list3 = list.stream().map(
            e -> e.entrySet().stream().collect(Collectors.toMap(
                    x -> {
                        if (x.getKey().equals("id")) {
                            return "sample_id";
                        } else if (x.getKey().equals("display")) {
                            return "sample";
                        } else {
                            return x.getKey();
                        }
                    },
                    Map.Entry::getValue))).collect(Collectors.toList());