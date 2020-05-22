public class Application {

    public static void main(String[] args) {
        Dto dto = new Dto();
        dto.setParam("Hello World!");

        System.out.println(dto.getParam());
    }
}