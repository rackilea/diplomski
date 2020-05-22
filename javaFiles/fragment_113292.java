class ApiWrapper {

    private Api api;

    // getters, setters, toString
}

class Api {

    private int results;
    private Map<String, Map<String, Match>> odds;

    // getters, setters, toString
}

class Match {

    private String label;
    private String pos;
    private String odd;

    // getters, setters, toString
}