static List<SomeObj> deepCopy(List<SomeObj> input) {
    List<SomeObj> output = new ArrayList<SomeObj>(input.size());

    for (SomeObj obj : input)
        output.add(new SomeObj(obj.num));

    return output;
}