public Object[][] createData() {
    patchfileName = "hi,how,are,you";
    patchsplit = patchfileName.split(",");
    Object[][] data = new Object[patchsplit.length][1];
    for (int x = 0; x < patchsplit.length; x++) {
        data[x][0] = patchsplit[x];

    }
    return data;
}