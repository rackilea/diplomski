Input input;     // keeps a ref to input

public Output(Input input) {
    super("Output", 300, 300);
    this.input = input;

    String ageStr = input.getAge();
...