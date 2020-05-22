List<FieldSubscriber<?>> list = subscribers.get(attr);
if (list == null) {
  list = new ArrayList<FieldSubscriber<?>>();
  subscribers.put(attr, list);
}
list.add(subscriber);