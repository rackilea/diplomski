public static <E extends Comparable<E>>List<E> getLCS(int i, int j, String[][] b, List<E> x){
        List<E> ret = new ArrayList<E>();


        if(i==0 || j ==0)
            return ret;

        if(b[i][j].equals("NW")) {
            // This can't be done because add returns a boolean type

            ret=getLCS(i-1,j-1, b, x);
            ret.add(x.get(i));
        }else if(b[i][j].equals("N")) {
            ret = getLCS(i-1,j, b, x);
        }else if(b[i][j].equals("W")) {
            ret= getLCS(i, j-1, b, x);
        }


        return ret;
    }