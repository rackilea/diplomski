@Autowired
private List<Color> colors;

public void doSomething(String input) {
    colors.stream().filter(c -> c.getName().contains(input)).findFirst().ifPresent(c -> {
        // something
    }
}