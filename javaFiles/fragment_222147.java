Collection<CallLog> callLogs = Arrays.stream(S.split("\n"))
  .map(CallLog::new)
  .collect(Collectors.toMap( //a collector that will produce a map
    CallLog::phoneNumber,    //using phoneNumber as the key to group
    x -> x,                  //the item itself as the value
    (a, b) -> {              //and a merge function that returns an object with combined billing
      a.billing += b.billing;
      return a;
    }))
  .values(); //just return the values from that map