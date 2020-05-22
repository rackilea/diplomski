public void onModuleLoad()
{

    Runnable onLoadCallback = new Runnable() 
    {
        public void run() {
            // first get the data
            getDateAndWarningCount()
        }          
    };
    VisualizationUtils.loadVisualizationApi(onLoadCallback, LineChart.PACKAGE);
    popUpGraph.add(vPanelWithGraph);
}

private LineChart.Options createLineOptions() 
{
    Options options = Options.create();
    options.setWidth(400);
    options.setHeight(240);
    options.setTitle("Graph Name");
    return options;
}

private AbstractDataTable createLineTable(HashMap<String,String> map) 
{       
    DataTable data = DataTable.create();
    data.addColumn(ColumnType.STRING, "Date");
    data.addColumn(ColumnType.NUMBER, "Number");

    data.addRows(2);

    String [] arrDate = new String [2];
    int  [] arrWarCount = new int [2];
    int i=0;
    Iterator it = map.entrySet().iterator();

    while (it.hasNext()) 
    {
        Map.Entry pairs = (Map.Entry)it.next();
        System.out.println(pairs.getKey() + " = " + pairs.getValue());
        arrDate[i]=""+pairs.getKey();
        arrWarCount[i]=Integer.parseInt((String)pairs.getValue());
        i++;
    }
    data.setValue(0, 0, arrDate[0]);// row column
    data.setValue(0, 1, 5);

    data.setValue(1, 0, arrDate[1]);
    data.setValue(1, 1, 6);

    return data;
}

private HashMap<String,String> getDateAndWarningCount()
{
    HashMap<String,String> map = null;
    SQLRunnerAsync service = (SQLRunnerAsync) GWT.create(SQLRunner.class);
    AsyncCallback<HashMap<String,String>>  callback = new AsyncCallback<HashMap<String,String>>()
    {
        @Override
        public void onFailure(Throwable caught) 
        {}

        @Override
        public void onSuccess(HashMap<String,String> result)
        {
                            Runnable onLoadCallback = new Runnable() 
            {
                public void run() 
                {
                    AbstractDataTable data = createLineTable(map);
                    Options options = createLineOptions();
                    LineChart lineChart = new LineChart(data, options);
                    vPanelWithGraph.add(lineChart);
                    vPanelWithGraph.add(closeGraphPopUp);
                }
            };
            VisualizationUtils.loadVisualizationApi(onLoadCallback, LineChart.PACKAGE); 
        }
    };
    service.getHashMapValues(callback); 
    return map;
    }

}