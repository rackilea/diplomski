public static void main(String[] args)
{
    List<Person> listPerson = null;        

    listPerson.stream()
        .collect(Collectors.groupingBy(i -> i.getDate().getMonth(), Collectors.collectingAndThen(Collectors.toList(),
            Scratch::apply
    )))
    .forEach((k,v) -> System.out.println(k.getValue() + "-" + v.toString()));
}

private static List<String> apply(List<Person> l)
{
    int sumAmount1 = l.stream().mapToInt(Person::getAmount1).sum();
    Double avgPerc1 = l.stream().collect(Collectors.averagingDouble(Person::getPercent1));
    List<String> data = new ArrayList<>();
    data.add(Integer.toString(sumAmount1));
    data.add(Double.toString(avgPerc1));
    return data;
}