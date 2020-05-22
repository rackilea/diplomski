// version 1.x MapRunner#run()
K1 key = input.createKey();
V1 value = input.createValue();

while (input.next(key, value)) {
   // map pair to output
   mapper.map(key, value, output, reporter);
   ...