public static void updateDataChart(){
    for (MyData data : myObservableList) {
        if ( data.isLucky() ) // or whatever is your condition
            dataLineChart.getData().add(data);
    }
}