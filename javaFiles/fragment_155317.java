public class FileCopierWithCamel2 {
    public static void main(String[] args) throws Exception {
        Main camelMain = new Main();
        camelMain.addRouteBuilder(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:data/inbox?noop=true").to("file:data/outbox");
            }
        });
        camelMain.run();
    }
}