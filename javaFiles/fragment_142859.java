for(int i=some_variable;i<arrayWidth;i++) {
    for (int j=other_variable;j<arrayHeight;j++) {
        try {
            int tmp=array[i][j];
            // do something
        } catch (ArrayIndexOutOfBoundsException e) {
            continue;
        }
    }
}