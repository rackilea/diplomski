public class ArrayTest {

    public static class Thing  {

        private int thingOne;
         public int getThingOne() { return thingOne; }
         public void setThingOne(int thingOne) { this.thingOne = thingOne; }

         private int thingTwo;
         public int getThingTwo() { return thingTwo; }
         public void setThingTwo(int thingTwo) { this.thingTwo = thingTwo; }

         @Override
         public String toString() {
             return "Thing{" +
              "thingOne=" + thingOne +
              ", thingTwo=" + thingTwo +
              '}';
         }

    }

    public static void main(String... args) {
        Thing[] array = new Thing[10];

        for (int i = 0; i < array.length; i++) {
            Thing thing = new Thing();
            thing.setThingTwo(new Random().nextInt(10));
            thing.setThingTwo(new Random().nextInt(10));
            array[i] = thing;
        }

        Arrays.stream(array).forEach(System.out::println);
    }

}