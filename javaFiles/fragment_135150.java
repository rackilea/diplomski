Boolean[][] gridBool = Arrays.stream(gridInt)
                .map(row -> Arrays.stream(row)
                        .mapToObj(i -> i == 1)
                        .toArray(Boolean[]::new)
                )
                .toArray(Boolean[][]::new);