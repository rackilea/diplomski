import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Scratch {
   static class Custom<T>{
       String a;
       List<T> nestedList;

       public Custom(String a, List<T> nestedList) {
           this.a = a;
           this.nestedList = nestedList;
       }

       public Custom(String a, T... nestedList) {
           this.a = a;
           this.nestedList = Arrays.asList(nestedList);
       }

       public String getA() {
           return a;
       }

       public void setA(String a) {
           this.a = a;
       }

       public List<T> getNestedList() {
           return nestedList;
       }

       public void setNestedList(List<T> nestedList) {
           this.nestedList = nestedList;
       }

       @Override
       public String toString() {
           return "Custom{" +
                   "a='" + a + '\'' +
                   ", nestedList=" + nestedList +
                   '}' +
                   '\n';
       }
   }



   public static void main(String... args){
       List<Custom> list = new ArrayList<>();
       list.add(new Custom<String>("1", "11", "22", "33"));
       list.add(new Custom<String>("2", "22", "44"));
       list.add(new Custom<String>("3", "11", "33"));

       List result = list.stream().map(
               x -> new Custom(x.getA(), x.getNestedList().stream().filter(y -> y.equals("22")).collect(Collectors.toList()))
       ).collect(Collectors.toList());

       System.out.println("input: "+list);
       System.out.println("result: "+result);
    }


}