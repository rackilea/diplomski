import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputFunction {

  private int doOperation(int a, int b, String operator) throws Exception {
    int result;
    if("+".equals(operator)){
      result = a + b;
    } else if("-".equals(operator)){
      result = a - b;
    } else if("*".equals(operator)){
      result = a * b;
    } else {
      throw new Exception("Unsupported operator \"" + operator + "\"");
    }
    return result;
  }

  private List<String> evaluate(List<String> function) throws Exception {
    List<String> processed = new ArrayList<>();
    if(function.size() <= 2) {
      return function;
    } else {
      for (int i = 0; i < function.size(); i += 3) {
        String a = function.get(i);
        if ((i + 1) < function.size()) {
          String b = function.get(i + 1);
          if ((i + 2) < function.size()) {
            String c = function.get(i + 2);
            if (a.matches("\\d+") && b.matches("\\d+") && !c.matches("\\d+")) {
              processed.add(String.valueOf(doOperation(Integer.valueOf(a), Integer.valueOf(b), c)));
            } else {
              processed.add(a);
              if(c.matches("\\d+")) {
                processed.addAll(evaluate(function.subList(i + 1, function.size())));
                break;
              } else {
                processed.add(b);
                processed.add(c);
              }
            }
          } else {
            processed.add(a);
            processed.add(b);
          }
        } else {
          processed.add(a);
        }
      }
    }
    return evaluate(processed);
  }

  private void doFunction(String input) throws Exception{
    List<String> function = Arrays.asList(input.split(" "));
    Collections.reverse(function);
    System.out.println(evaluate(function));
  }

  public static void main(String ... args) {
    InputFunction inputFunction = new InputFunction();
    try {
      inputFunction.doFunction("+ + 5 5 + 5 5");
      inputFunction.doFunction("* + 16 * + 16 4 + 3 1 + 3 1");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}