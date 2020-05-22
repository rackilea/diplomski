public Analyzer(String simulation, DBConnector connection){

    this(new String[]{simulation}, connection);
    source = simulation;
}

public Analyzer(String[] simulation, DBConnector connection){

    super();
    for( String s : simulation) this.simulations.add(s);
    this.connection = connection;
}