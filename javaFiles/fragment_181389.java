DataSource dataSource = grid.getDataSource();
dataSource.removeData(record,new DSCallback() {

    @Override
    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest){
        Record[] records=dsResponse.getData();//deleted records

        grid.fetchData();//fetch data again
    }
});