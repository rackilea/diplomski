int[][] dataArr = new int[list.size()][];

for(int i = 0; i < list.size(); i++) {
    dataArr[i] = new int[list.get(i).length];
    for(int j = 0; j < dataArr[i].length; j++) {
        dataArr[i][j] = Integer.parseInt(list.get(i)[j]);
    }
}