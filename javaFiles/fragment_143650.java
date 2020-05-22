public class Sandbox {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        A implA = new Impl();
        B implB = new Impl();

        String jsonA = null;
        String jsonB = null;
        try {
            ObjectWriter jsonAWriter = mapper.writerWithView(A.class);
            jsonA = jsonAWriter.writeValueAsString(implA);

            ObjectWriter jsonBWriter = mapper.writerWithView(B.class);
            jsonB = jsonBWriter.writeValueAsString(implB);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonA);
        System.out.println();
        System.out.println(jsonB);
    }

    public interface A {
        String getA();
    }

    public interface B {
        String getB();
    }

    public static class Impl implements A, B {

        @Override
        @JsonView(A.class)
        public String getA() {
            return "stringA";
        }

        @Override
        @JsonView(B.class)
        public String getB() {
            return "stringB";
        }
    }
}