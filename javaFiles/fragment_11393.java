List<String> x = Arrays.asList("a1", "a2", "a3");
List<String> y = Arrays.asList("b1", "b2", "b3");
List<String> z = Arrays.asList("c1", "c2", "c3");
int n = x.size();
List<String> list = new ArrayList<>();
IntStream.range(0, n)
         .boxed()
         .forEach(i -> { list.add(x.get(i)); 
                         list.add(y.get(i)); 
                         list.add(z.get(i)); 
                        });