// Adapter to load data from an existing array.
DatabaseConnection dbc = new ArrayAdapterDatabaseConnection(data);
// Create a database (which may contain multiple relations!)
Database db = new StaticArrayDatabase(dbc, null);
// Load the data into the database (do NOT forget to initialize...)
db.initialize();