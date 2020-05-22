public class DreamCarMain {
    public static void main(String[] args) {

        Main.main(new String[] { "-g", "org.phan.kata.cucumber.integration.stepdefs", "-p", "pretty", "-t", args[0], "classpath:features" });
    }
}