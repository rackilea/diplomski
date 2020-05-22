public static void main (String[] args) {
  ArrayList<ArrayList<ArrayList<String>>> input;
  String[][][]                            output;
  String[][]                              tmp;
  ArrayList<ArrayList<String>>            lvl2;
  ArrayList<String>                       lvl3;

  input = new ArrayList<ArrayList<ArrayList<String>>>();
  input.add(new ArrayList<ArrayList<String>>());
  input.get(0).add(new ArrayList<String>());
  input.get(0).get(0).add("foobar");

  output = new String[input.size()][][];
  for (int outer = 0; outer < input.size(); ++outer) {
    lvl2 = input.get(outer);
    tmp  = new String[lvl2.size()][];
    for (int inner = 0; inner < lvl2.size(); ++inner) {
      lvl3       = lvl2.get(inner);
      tmp[inner] = lvl3.toArray(new String[lvl3.size()]);
    }
    output[outer] = tmp;
  }
}