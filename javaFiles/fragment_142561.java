//Assuming you fill listOfParameters with all the parameters.
    Collections.sort(listOfParameters, new Comparator<String>() {
       int compare(String a,String b) {
            return Integer.getInt(a.substring(0,a.indexOf("_"))) - Integer.getInt(a.substring(0,b.indexOf("_")))
       }
    }
    );
    for (String param : listOfParameters) {
        //traverse in order of the prefix
    }