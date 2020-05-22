OUT fn2(IN in1, IN in2) {
    //safe because the array won't be exposed outside the list
    @SuppressWarnings("unchecked")
    final List<IN> ins = Arrays.asList(in1, in2);
    return fnN(ins);
}

abstract OUT fnN(List<? extends IN> ins);