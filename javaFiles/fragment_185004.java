public class HadoopTest {
MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;

@Before
public void setUp() {
    SalesMapper mapper = new SalesMapper();
    mapDriver = new MapDriver<LongWritable, Text, Text, IntWritable>();
    mapDriver.setMapper(mapper);
}

@Test
public void testMapper() throws Exception {
    mapDriver.withInput(new LongWritable(1), new Text("date,product,1200,Visa,carolina,baslidoni,england,UK"));
    mapDriver.withOutput(new Text("UK"), new IntWritable(1200));
    mapDriver.runTest();
}
}