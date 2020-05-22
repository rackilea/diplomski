import org.apache.edgent.function.Predicate;
import org.apache.edgent.function.Consumer;


public static void main( String[] args ) throws Exception
{
    TempSensor sensor = new TempSensor();
    DirectProvider dp = new DirectProvider();
    Topology topology = dp.newTopology();

    TStream<Double> tempReadings = topology.poll( sensor, 1, TimeUnit.MILLISECONDS );
    TStream<Double> filteredStream = tempReadings.filter( new Predicate<Double>()
    {
        public boolean test( Double reading )
        {
            return !optimalTempRangeRef.get().contains( reading );
        }
    } );

    filteredStream.sink( new Consumer<Double>()
    {
        public void accept( Double reading )
        {
            System.out.println( "Temperature is out of range! "
                                + "It is " + reading + "\u00b0F!" )
        }
    } );

    tempReadings.print();

    dp.submit( topology );
}