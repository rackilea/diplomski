public static void main(String[] args) {
    List<Container> containersList = Arrays.asList(new Container("A"), new Container("B"), new Container("A"), new Container("A"), new Container("B"));

    String[] result = containersList.stream().parallel().map(Container::getLetter).collect(ContainerCollector.collector());

    System.out.println(result[0]);
    System.out.println(result[1]);
}

private static final class ContainerCollector {

    private StringBuilder text = new StringBuilder();
    private StringBuilder dupText = new StringBuilder();

    private void accept(String letter) {
        text.append(letter);
        if (dupText.indexOf(letter, dupText.length() - letter.length()) < 0) {
            dupText.append(letter);
        }
    }

    private ContainerCollector combine(ContainerCollector other) {
        text.append(other.text);
        other.dupText.codePoints().forEach(i -> {
            String letter = new String(Character.toChars(i));
            if (dupText.indexOf(letter, dupText.length() - letter.length()) < 0) {
                dupText.append(letter);
            }
        });
        return this;
    }

    private String[] finish() {
        return new String[] { text.toString(), dupText.toString() };
    }

    private static Collector<String, ?, String[]> collector() {
        return Collector.of(ContainerCollector::new, ContainerCollector::accept, ContainerCollector::combine, ContainerCollector::finish);
    }

}