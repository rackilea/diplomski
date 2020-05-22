private List<Output> getOutPutListFromInputList(List<Input> inPutList)
{
    return listOfPoolsInRun.stream()
                           .map(input -> {
                                Output out = new Output();
                                out.setArg1(input.getArg2());
                                out.setArg2(input.getArg7());
                                return out;
                            })
                           .collect(Collectors.toList()); 
}