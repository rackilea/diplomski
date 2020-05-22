@Before
public void setUp() throws Exception {
    this.filter = new AveragingFilter(); // or something like it
    this.dataSet = new SensorData();
    dataSet.setFilter(filter);
}