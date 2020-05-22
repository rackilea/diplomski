Integer counter = mapper.get(category);
if (counter == null) {
  counter = 0;
  mapper.put(category, counter);
}
counter++;