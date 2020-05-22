public interface A {
    String getStringA();
}

public interface B {
    String getStringB();
}

public class AB implements A, B {

    @Override
    public String getStringA() {
        return "value a";
    }

    @Override
    public String getStringB() {
        return "value b";
    }
}

@Test
public void t() throws JsonProcessingException {
    final ObjectMapper mapper = new ObjectMapper();

    final String a = mapper.writerFor(A.class).writeValueAsString(new AB());
    assertThat(a).isEqualTo("{\"stringA\":\"value a\"}");

    final String b = mapper.writerFor(B.class).writeValueAsString(new AB());
    assertThat(b).isEqualTo("{\"stringB\":\"value b\"}");
}