public class Arrayz {
  public static void main(String[] args) {
    List<Integer> array1 = new ArrayList<>();
    array1.add(new Integer(1));
    array1.add(new Integer(2));
    List<Integer> array2 = new ArrayList<>(array1);
// you can't mutate Integer - it's immutable
    Integer first = array2.get(0); 
    System.out.println(array1);
    System.out.println(array2);

    List<Nom> array3 = new ArrayList<>();
    array3.add(new Nom(1));
    array3.add(new Nom(2));
    List<Nom> array4 = new ArrayList<>(array3);
    Nom third = array4.get(0);
// Nom is muttable - this will affect initial data as the Object itself mutated
    third.a = 88; 
// this will not - you replaced the Object in copied array only
    array4.set(1, new Nom(33)); 
    System.out.println(array3);
    System.out.println(array4);
  }
}

public class Nom {
  public int a;
  Nom(int a) {
    this.a = a;
  }

  @Override
  public String toString() {
    return "" +a;
  }
}
//////////// output:
[1, 2] // array1
[1, 2] // array2
[88, 2] // array3
[88, 33] // array4