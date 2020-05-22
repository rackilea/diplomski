public class Sort {

  public static void main(String[] args) {
    int[] arr = new int[]{14, 9, 7, 7, 14};
    Map<Integer, Temp> map = new HashMap<>();

    for(int i: arr){
      Temp t = map.getOrDefault(i, new Temp(i));
      map.put(i,t.increment()); 
    }
    List<Temp> l = new ArrayList<>(map.values());
    Collections.sort(l, (o,t)-> o.count ==t.count ?o.value - t.value : t.count-o.count);

    List<Integer> finalList = new ArrayList<>() ;
    for(Temp t: l){
       for(int i=0;i<t.count;i++){
         finalList.add(t.value);
       }
    }
    System.out.println(finalList);
  }

  static class Temp{
    int value, count;
    public Temp(int i) {
      value=i;
    }
    public Temp increment(){
      count++;
      return this;
    }

  }