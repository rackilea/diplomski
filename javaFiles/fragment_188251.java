map.entrySet()
   .stream()
   .collect(Collectors.toMap(
           Entry::getKey,
           e -> e.getValue() // List<Houses>
                 .stream()
                 .filter(h -> h.getColor() == Color.BLUE)
                 .collect(Collectors.toList())
   ));