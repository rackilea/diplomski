public static class FirstOrNot {
    private static FirstOrNot _instance;

    public synchronized boolean isfirst() {
        if ( _instance == null ) {
            _instance = new FirstOrNot();
            return true;
        }
        return false;
    }
}

FirstOrNot first = new FirstOrNot();

from("webspheremq:topic:SNAPSHOTS")
    .filter().method( first , "isFirst" )
    .to("direct:anotherqueue")