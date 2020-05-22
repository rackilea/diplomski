public class SNMPTrap {

    private Main main;

    public static void main(String[] args) throws Exception {
        SNMPTrap snmpTrap = new SNMPTrap();
        snmpTrap.boot();
    }

    @SuppressWarnings("deprecation")
    public void boot() throws Exception {

        main = new Main();
        main.bind("snmp", new SnmpComponent());
        main.addRouteBuilder(new MyRouteBuilder());
        main.addMainListener(new Events());

        System.out.println("Starting SNMPTrap. Use ctrl + c to terminate the JVM.\n");
        main.run();
    }

    private static class MyRouteBuilder extends RouteBuilder {
        @Override
        public void configure() throws Exception {
            from("snmp:127.0.0.1:162?protocol=udp&type=TRAP").process(myProcessor)
                .bean("snmp");
        }
    }

    public static Processor myProcessor = new Processor() {
        public void process(Exchange trap) throws Exception {
            System.out.println(trap.getIn().getBody(String.class));

            // Save to DB or do other good stuff
        }
    };

    public static class Events extends MainListenerSupport {

        @Override
        public void afterStart(MainSupport main) {
            System.out.println("SNMPTrap is now started!");
        }

        @Override
        public void beforeStop(MainSupport main) {
            System.out.println("SNMPTrap is now being stopped!");
        }
    }
}