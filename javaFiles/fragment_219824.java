static List<SomeObj> shallowCopy(List<SomeObj> input) {
    List<SomeObj> output = new ArrayList<SomeObj>(input.size());

    for (SomeObj obj : input)
        output.add(obj);

    return output;
}