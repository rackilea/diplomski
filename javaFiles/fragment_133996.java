public static void main(String[] args) {
    String jsonString = "{\"name\" : \"DOB\", \"operator\" : \"<\", \"value\" : \"CURRENTDATE + 3\"}";
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    Test test = gson.fromJson(jsonString, Test.class);
    System.out.println(test);
}

public class Test {
    String name;
    String operator;
    String value;

    @Override
    public String toString() {
        return "Test [name=" + name + ", operator=" + operator + ", value=" + value + "]";
    }
}