public static void main(String[] args) {
    // this graph is directional

    BufferedReader br = null;
    String line = "";
    String eachLine = "";
    List<String> list = new ArrayList<String>();

    Graph graph = new Graph();
    try {
        br = new BufferedReader(new FileReader("Data.txt"));

        while (line != null) {
            list.add(line);
            line = br.readLine();
        }
        String[] stringArr = list.toArray(new String[0]);
        for (int i = 1; i <= stringArr.length - 1; i++) {

            String eachLinesArray[] = stringArr[i].split(",");
            graph.addEdge(eachLinesArray[0], eachLinesArray[1]);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    Search ss = new Search(graph);
    ss.launchFrame();

}