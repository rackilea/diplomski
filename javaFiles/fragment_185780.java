public void someWhere() {
    try {
        PlotWriter pw = new PlotWriter(".../path/file");
    } catch (FileNotFoundException ex) {
        // handle exception here
    }
}