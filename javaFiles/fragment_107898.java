public int sumLines(Function<Line, Integer> extractor){
    Line[] lines = ...
    return Arrays.stream(lines).map(extractor)
        .filter(Objects::nonNull).mapToInt(i -> i).sum();
}
....
int time = sumLines(Line::getTime);