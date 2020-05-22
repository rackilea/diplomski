class Foo {
    int numRows = 3;
    int numCols = 2;
    char[][] x = new char[][] { { 'a', '*' }, { 'x', 'y' }, { '*', '#' } };

    public String toString() {
        StringBuilder sb = new StringBuilder(numRows * (numCols + 1));
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if (x[i][j] == ('*')) {
                    sb.append('*');
                    System.out.print('*');
                } else {
                    sb.append(' ');
                    System.out.print(' ');
                }
                System.out.println();
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Foo foo = new Foo();
        System.out.println(foo.toString());
    }
}