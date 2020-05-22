void resursivelyCombine(List<List<Boolean>> result, List<Boolean> current, List<Boolean> in1, List<Boolean> in2, int index) {
    if (index == in1.size()) {
        result.add(current);
    } else {
        if (in1.get(index).equals(in2.get(index))) {
           current.add(in1.get(index));
           recursivelyCombine(result, current, in1, in2, index+1);
        } else {
           List<Boolean> temp = new ArrayList<>(current);
           temp.add(Boolean.TRUE);
           recursivelyCombine(result, temp, in1, in2, index+1);

           temp = new ArrayList<>(current);
           temp.add(Boolean.FALSE);
           recursivelyCombine(result, temp, in1, in2, index+1);
        }
    }
}