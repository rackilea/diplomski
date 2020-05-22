ExecutorService es = Executors.newCachedThreadPool();
es.invokeAll(items.stream()
    .map(i -> Executors.callable(i::load))
    .collect(Collectors.toList()));
es.shutdown();

List<Prop> result = new ArrayList<>(); 

for(Item item : items) {
      Prop temp = new Prop();
      // once the item is loaded, get its properties
      temp.setProp1(item.getProp1());
      temp.setProp2(item.getProp2());

      result.add(temp);
}

return result;