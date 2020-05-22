public static String whereQuery(String someValue){
        return "function() {" +
                    "for (var index in this.*someKey*){" +
                        "if (index.indexOf(\""+ someValue+"\") > -1){" +
                          "return this;" +
                         "}" +
                     "}" +
                "}";
    }