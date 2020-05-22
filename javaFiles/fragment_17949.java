public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        View view = new View();
        AbstractController controller = new ConcreteController(view);
        // .....
    });
}