barList.stream()
        .filter(bar -> fooList.stream()
                .map(Main::fooToBlah)
                .noneMatch(foo -> foo.equals(barToBlah(bar)))
        )
        .forEach(System.out::println);