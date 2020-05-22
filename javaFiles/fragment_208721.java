@WebService
@Stateless
public class CalculatorBean implements Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}