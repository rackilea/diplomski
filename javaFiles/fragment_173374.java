import java.util.*;

class Hello{

    List<Example> exam = new ArrayList<Example>();

    public void execute() throws Exception{
      add(1);
      add(2);
      add(3);
      add(1);

      for(Example ex:exam){
          test(ex)
      }
    }

    public void add(Integer value) throws IllegalArgumentException{
        if(exam.contains(value)){
          throw new IllegalArgumentException("Number is already added.");
        }
        exam.add(value);

    }

    public void test(Example example){
        System.out.println("Running test on Example: " + example);//pl.test(ex);
    }

    public static void main(String[] args){
      Hello hello = new Hello();
      hello.add(1);
      hello.add(2);
      hello.add(3);
      hello.add(1);
    }
}

class Example{}