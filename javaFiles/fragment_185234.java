@CsvDataType()
public class Person {
    @CsvField(pos = 1)
    String name;

    @CsvField(pos = 2, format = "dd.MM.yyyy")
    Date   birthDate;
}