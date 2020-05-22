int lastRow = temp.length - 1;
int lastCol = temp[0].length - 1;
temp[0] = data[0];
temp[lastRow] = data[lastRow];

for(int i = 1; i < lastRow; ++i) {
    temp[i][0] = data[i][0];
    temp[i][lastCol] = data[i][lastCol];
}
pt.setData(temp);