"create\\s+(or\\s+replace\\s+)?(package)\\s+(body\\s+)?([\\w\\.]+)" +//1-4
        "|(\\bcreate\\s+)?(\\bor\\s+)?(\\breplace\\s+)?(\\bfunction|\\bprocedure)\\s+(\\w+)" +//5-9
        "|(\\bexception)\\s" +//10
        "|(\\bcursor)\\s*(\\w+)"+//11-12
        "|(\\bloop)\\s"+//13
        "|(\\w+)\\s*([\\w\\.]+)\\s*%(ROW)?(TYPE);"+//14-17
        "|(\\bdeclare)\\s"//18