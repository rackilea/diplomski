public class Skill {
    private Calculator calc;
    public Skill(Calculator calc) { this.calc = calc; }
}

public class Calculator {
    private Skill sk = new Skill(this);
}