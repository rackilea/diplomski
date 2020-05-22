JSSourceFunction dateSortFunction = new JSSourceFunction(
    "function(v) {" +
        "var arr = v.sort(function(a, b) {" +
            "return a.issueDate - b.issueDate ;" +
            "}" +
        ");" +
        "if (arr.length == 0) { " +
           "return [];" +
        "} else {"
           "return arr[0];" + 
        "}"
    "}"
);