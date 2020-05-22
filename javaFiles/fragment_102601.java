private String [] functionNames = {"AND", "OR", "NOT", "IF"};
private int [] functionArities = {2,2,1,3};

public Node getFunction() {
    int index = random.nextInt(3); // If you want to use "IF" nodes too this
                                   // needs to be nextInt(4)
    return new Node(functionArities[index],functionNodes[index]);
}