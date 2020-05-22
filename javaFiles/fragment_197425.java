colors.stream().forEach(cols ->
        System.out.println(cols + " count: " + numbers2
                        .mapToObj(i -> colors[i])
                        .filter(c -> c.equals(cols))
                        .count()
                ));