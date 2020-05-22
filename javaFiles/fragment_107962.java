public static void addRows(String tableBdId, String[] data, String rowId) {

    Util dwrUtil = new Util(getSessionForPage()); // Get all page sessions

    // Create the options, which is needed to add a row ID
    String options = "{" +
            "  rowCreator:function(options) {" +
            "    var row = document.createElement(\"tr\");" +
            "     row.setAttribute('id','" + rowId + "'); " +
                    "    return row;" +
                            "  }," +
            "  cellCreator:function(options) {" +
            "    var td = document.createElement(\"td\");" +
            "    return td;" +
                 "  }," +
            "  escapeHtml:true\"}";


    // Wrap the supplied row into an array to match the API
    String[][] args1 = new String[][] { data };
    dwrUtil.addRows(tableBdId, args1, options);