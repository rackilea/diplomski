interface CanDoSomething {
    public doSomething();
}

class ClassA implements CanDoSomething {..}
class ClassB implements CanDoSomething {..}

private void iterateListAlgo(List<CanDoSomething> items) {
   for (CanDoSomething item : items) {
       item.doSomething();
   }
}