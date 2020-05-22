JSONArray ja = new JSONOArray(string);
int[][] result = new int[ja.length()][];
for (int i = 0; i < ja.length(); i++) {
    JSONAarray ja2 = ja.getJSONArray(i);
    result[i] = new int[ja2.length()];
    for (int j = 0; j < ja2.length(); j++) {
        result[i][j]=ja2.getInt(j);
    }
}