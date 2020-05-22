List<ParsingProblem> problems = new ArrayList<ParsingProblem>();
while (parsing) {
  ...
  problems.add(new ParsingProblem("some message", someRelevantValue));
}

if (!problems.isEmpty()) {
   throw new ParsingException(problems);
}