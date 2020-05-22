private List<Output> getOutPutListFromInputList(List<Input> inPutList) 
{
    return listOfPoolsInRun.stream()
                           .map(input -> new Output(input.getArg2(),input.getArg7()))
                           .collect(Collectors.toList()); 
}