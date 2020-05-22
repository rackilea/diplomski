public class MyModel implements AbstractTableModel {
  private ArrayList<Integer> data;

  ...
  // implement interface methods
  ...

  public void sortToTop(int a) {
    // float all rows w/ a in the first column to the top
    Collections.sort(data, new Comparator<Integer>() {
        public int compare(int o1, int o2) {
            if (o1 == a) return -1;
            if (o2 == a) return 1;
            return o1.compareTo(o2);
        }
    });
    // find how many rows at the top have a in the first row
    int startIndex = 0;
    boolean notFound = true;
    while (startIndex < data.size() && notFound) {
        if (data.get(startIndex) == a)
            startIndex++;
        else 
            notFound = false;
    }
    int endIndex = data.size();
            // get a sublist w/o these first rows
    List<Integer> sublist = data.subList(startIndex, endIndex);
    // sort sublist on the second column floating a to the top
    Collections.sort(sublist, new Comparator<Integer>() {
        public int compare(int o1, int o2) {
            if (o1 == a) return -1;
            if (o2 == a) return 1;
            return o1.compareTo(o2);
        }
    });
    this.fireTableDataChanged();
  }
}