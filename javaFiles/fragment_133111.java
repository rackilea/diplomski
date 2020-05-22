public class MainJava {
    interface Publisher { void subscribe(Subscriber s); }
    interface Subscriber { void update(); }

    public static void main(String... args) {
        TableComponent component = new TableComponent(new TableBody(), new TableHeader(), new TableFooter());
        component.setBodyText("Hello World");
    }

    static class TableComponent {
        final TableBody body;
        final TableHeader header;
        final TableFooter footer;

        public TableComponent(TableBody body, TableHeader header, TableFooter footer) {
            this.body = body;
            this.header = header;
            this.footer = footer;
            body.subscribe(header);
        }
        public void setBodyText(String newBody) {
            body.edit(newBody);
        }
    }

    static class TableBody implements Publisher {
        final Set<Subscriber> subscribers = ConcurrentHashMap.newKeySet();
        @Override
        public void subscribe(Subscriber s) {
            subscribers.add(s);
        }
        void edit(String newBody) {
            System.out.println(newBody);
            subscribers.forEach(Subscriber::update);
        }
    }
    static class TableHeader implements Subscriber {
        @Override
        public void update() {
            System.out.println("Toggle Button");
        }
    }
    static class TableFooter {}
}