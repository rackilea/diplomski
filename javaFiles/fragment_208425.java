component {

    public void function onIncomingMessage (required struct msg) {

        var sys = createObject("java", "java.lang.System");
        var tag = createUUID();
        var logFile = "test\gatewaytest";

        writelog (file=logFile, text="#tag# - about to queue");

        try {

            lock name="myTestLock" timeout="120" {
                writelog (file=logFile, text="#tag# - got lock");

                thread action="sleep" duration="5000"; //ms 
            }

            writelog (file=logFile, text="#tag# - released lock");

        } catch (any e) {
            writelog (file=logFile, text="#tag# - ERROR - #e.message#");
        }
    }
}