public void PrintSmaller(int number) {

    InfoArray.stream().filter(e -> e.getValue() < number()).forEach(System.out::println);

    }

public void PrintLarger(int number) {

    InfoArray.stream().filter(e -> e.getValue() > number()).forEach(System.out::println);
    }
}