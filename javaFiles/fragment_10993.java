DSLContext create;
Table table = new Table(/* Whatever Arguments */);
TableUnmapper unmapper = new TableRecordUnmapper();

// Insert
create.insertInto(TABLES).set(unmapper.unmap(table));

// update
create.executeUpdate(unmapper.unmap(table));