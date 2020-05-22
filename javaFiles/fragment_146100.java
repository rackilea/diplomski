public class Board {
   private Map<String, int[][]> rows;
   private String code;
   private int tries;

public Board(String code, int size) {
    this.code = code;
    this.tries = 0;
    this.rows = new HashMap<>(size);
}

public Map<String, int[][]> getRows(String code) {
    return rows !=null ? rows.get(code):null;
}

public void setRows(String code, int[][] data) {
    if(rows == null)
       rows = new HashMap<>();

    rows.put(code,data);
}