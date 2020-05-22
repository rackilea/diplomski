class AWholeProgram {

    static EventManager E = new EventManager();

    public static void main(String[] args) {

        E.add (  new PhoneCall("15555551212")  );
        E.add(  PrintBatteryLevel  );
        E.add(  PlaySong  );
        E.add(  WaitForIncomingCall  );

    }

    // so the "events", the only things that can happen, are up front...
    final static Event PrintBatteryLevel = ...;
    final static Event PlaySong  = ...;
    final static Event WaitForIncomingCall  = ...;
    final static Event PhoneCall = new phoneCall("15555551212")...;


    class phoneCall extends Event {
        long number = Long.parseString("15555551212");
        phoneCall( String s ) {
          //convert to digits, and look in the phone book, and see if its long distance, etc.
        }
        public void fireEvent() {
           // makes the phone call
        }        
    }

}