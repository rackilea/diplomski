private static final String jsLib = "var T = {" +
        "results: new java.util.HashMap()," +
        "methodA: function (p1) {" +
        "   this.results.put('p1', p1);" +
        "   return this;" +
        "}," +
        "methodB: function (p2, p3) {" +
        "   this.results.put('p2', p2);" +
        "   this.results.put('p3', p3);" +
        "   return this;" +
        "}," +
        "methodC: function (p4) {" +
        "    this.results.put('p4', p4);" +
        "    return this.results;" +
        "}}";