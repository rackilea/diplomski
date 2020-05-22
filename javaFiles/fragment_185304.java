IntWritable value = null;
Iterator iterator = values.iterator();
while (values.iterator().hasNext()) {
  value = iterator.next().get();
  if (value != missing){
    sumResult = sumResult + value;
  }
}