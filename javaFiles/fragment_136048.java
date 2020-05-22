public Range(String range, Function<String, ? extends T> parser){
    Scanner scanner = new Scanner(range);
    if(scanner.hasNext())
        this.lower = parser.apply(scanner.next());
    if(scanner.hasNext())
        this.upper = parser.apply(scanner.next());
}