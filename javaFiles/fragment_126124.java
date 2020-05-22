..begin transaction

MainRecord mainRecord = new MainRecord();

Ref1 ref1 = new Ref1();
ref1.setValue("tettset");

Ref2 ref2 = new Ref2();
ref2.setValue("tettset");

mainRecord.setRef2(ref2);
mainRecord.setRef1(ref1);

entitymanager.persist(mainRecord);

..commit transaction.