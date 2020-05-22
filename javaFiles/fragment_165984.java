Integer counter = mapper.get(category);
if (counter == null) {
  counter = 0;
}
counter++;
mapper.put(category, counter);