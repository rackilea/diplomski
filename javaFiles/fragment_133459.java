...
List<Integer> values = new ArrayList<Integer>();

int j = 0;
for(int i = xMin;i < xMax + 1;i++){
    for(int k = yMin;k < yMax + 1;k++){

        values.add(new Integer(img[i][k]));
        ...
    }
}