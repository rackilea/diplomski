return employees.stream()
       .collect(HashMap::new,
                (map, e) -> {
                  String number = e.determineUniqueNINumber();
                  map.put(number, new Hyperlink( e.getName(), number));
                },
                Map::putAll);