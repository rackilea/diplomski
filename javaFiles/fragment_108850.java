public List<List<String>> depthList;
public  void CreateList(int deep) {
    depthList= new ArrayList<List<String>>();

    for (int d_i = 0; d_i <deep; d_i++) {
        depthList.add(new ArrayList<String>());
    }

}