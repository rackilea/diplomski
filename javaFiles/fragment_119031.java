public class TableCellsBean {

    private String name;
    private double value;

    public TableCellsBean(String name,double value){
        this.name = name;
        this.value = value;
    }
    public static JRBeanCollectionDataSource getDatasource(String fieldValue){
        List<TableCellsBean> retList = new ArrayList<>();
        String[] values = fieldValue.split(":");
        for (String v : values) {
            String[] sp = v.split("_");
            retList.add(new TableCellsBean(sp[0], Double.parseDouble(sp[1])));
        }
        return new JRBeanCollectionDataSource(retList);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
}