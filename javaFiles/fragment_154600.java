list.stream()
     .map(a -> new A(a.getCode(), a.getTimestamp(),
                list.stream()
                    .filter(b -> a.getCode().equals(b.getCode()))
                    .mapToLong(A::getTimestamp)
                    .max().getAsLong()))           
     .collect(Collectors.toList());