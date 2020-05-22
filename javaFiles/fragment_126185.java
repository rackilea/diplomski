public static Dataset<Person> transformToPerson(Dataset<Row> rawData) {
    return rawData.flatMap(row -> {
        String[] nameArr = row.getString(0).split(",");
        String[] genArr = row.getString(1).split(",");
        String[] ageArr = row.getString(2).split(",");
        Person person1 = new Person(nameArr[0], genArr[0], ageArr[0]);
        Person person2 = new Person(nameArr[1], genArr[1], ageArr[1]);
        return Arrays.asList(person1, person2).iterator();
    }, Encoders.bean(Person.class));
}

//Call function
Dataset<Person> dataset1 = transformToPerson(dataset);
dataset1.show();