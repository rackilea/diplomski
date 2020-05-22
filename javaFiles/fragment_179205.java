final MyFileInfo info = new MyFileInfo();
Session session = sessionFactory.getCurrentSession();

// saveOrUpdate actually gets the id from Hibernate's sequence cache,
// which doesn't need a flush
session.saveOrUpdate(info);

// then I can set the ID where appropriate and save (update) the "new" entity
info.setMyFileData(new MyFileData(info));
info.getMyFileData().setFileId(info.getId());
session.saveOrUpdate(info.getMyFileData());

// the flush will save the MyFileInfo object and perform a no-
// consequence update on the MyFileData object.
session.flush();
session.refresh(info);