private void addEntry() {
        LineData data = mChart.getData();
        ILineDataSet set = data.getDataSetByIndex(0);
        if (set == null) {
            set = createSet();
            data.addDataSet(set);
        }             
        data.addEntry(new Entry(data.getDataSetByIndex(dataSetIndex).getEntryCount(), yValue), dataSetIndex);
        data.notifyDataChanged();
        mChart.notifyDataSetChanged(); 

}