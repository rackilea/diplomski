public class AppServiceImpl implements AppService {
    String value_one;
    String value_two;
    String value_three;

    //values are null here
    public AppServiceImpl(String value1, String value2, String value3) {
        value_one = value1;
        value_two = value2;
        value_three = value3;
        functionOne(value_one, value_two, value_three);
    }
}