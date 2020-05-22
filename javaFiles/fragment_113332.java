import com.google.gson.Gson;

class Matrix implements Serializable {
    Integer[][] matrix;
    Matrix(){};

    public static  void main(String[] args) {
        Gson gson = new Gson();
        Matrix matrix = gson.fromJson("{\"matrix\" : [[20,5],[24,11],[24,13]]}", Matrix.class);
        System.out.println("matrix = \n" + matrix);

    }

    public String toString() {
        String res = "";
        if (matrix == null)
            return res;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                res += matrix[i][j] + ",";
            }
            res += "\n";
        }
        return res;
    }
}