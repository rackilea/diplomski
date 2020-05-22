LinkedTable linkedTable = new LinkedTable();
linkedTable.setId(1l);
session.persist(linkedTable);
session.flush();

Test.TestId testId = new Test.TestId();
testId.setLinkedTable(linkedTable);
Test test = new Test();
test.setId(testId);
session.persist(test);
session.flush();