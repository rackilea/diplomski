public interface ComputerComponent {
    String getName();
    ComponetType getType();
    ...
}

Tree<ComputerComponent> network;