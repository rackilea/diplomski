// All LargeObject API calls must be within a transaction block
conn.setAutoCommit(false);

// Get the Large Object Manager to perform operations with
LargeObjectManager lobj = ((org.postgresql.PGConnection)conn).getLargeObjectAPI();

// Create a new large object
int oid = lobj.create(LargeObjectManager.READ | LargeObjectManager.WRITE);

// Later you will be able to access data loading it by `oid` identifier.
// Or you can save it's value to some row in database

// Open the large object for writing
LargeObject obj = lobj.open(oid, LargeObjectManager.WRITE);

// Do your job here and stream the content
// Multiple obj.write calls expected

// Close the large object
obj.close();

// Finally, commit the transaction.
conn.commit();