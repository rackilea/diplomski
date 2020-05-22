Pattern pattern = Pattern.compile(
                 "[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)");

try(BufferedReader br=new BufferedReader(System.console().reader())) {

    br.lines()
      .flatMap(line -> StreamSupport.stream(new MatchItr(pattern.matcher(line)), false))
      .collect(Collectors.groupingBy(o->o, TreeMap::new, Collectors.counting()))
      .forEach((k, v) -> System.out.printf("%s\t%s\n",k,v));
}