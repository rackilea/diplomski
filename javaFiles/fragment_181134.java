NoiseFilter filter;
SensorData dataSet;


@Before
public void setUp() throws Exception {
    this.dataSet = new SensorData();
    dataSet.setFilter(filter);
}