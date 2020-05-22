List<Line> lines = Arrays.asList(
             new FirstLine("Every"),    // note this class is different
             new Line("word"), 
             new Line("on"), 
             new Line("separate"), 
             new Line("line") );

StringBuffer sb = new StringBuffer();

for (Line l : lines) {
    // Again the decision is delegated. Data knows how to print itself
    // Line would return: "\n" + s
    // FirstLine would return: s
    sb.append( l.getPrintVersion() );
}