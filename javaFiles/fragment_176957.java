TableModel myModel = ...;
List<TableModel> resultModels = new ArrayList<>(5);
TableModel[] split = SplitTableModel.split(myModel, 3);
for (int i = 0; i < 4; i++) {
    resultModels.add(split[0]);
    if (i == 3) {
        resultModels.add(split[1]);
    } else {
        split = SplitTableModel.split(split[1], 3);
    }
}