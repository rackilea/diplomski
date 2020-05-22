ListArray<Test> list = new ListArray<Test>();
// INSERT VALUES

public Test[] listToArray(ArrayList<Test> list) {
     Test [] result = new Test [list.size());
     for (int i = 0; i<list.size(); i++) {
        result[i] = list.get(i);
     }
     return result;
}