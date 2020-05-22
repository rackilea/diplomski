Session session = sessionDao.getObject(sessionId);
Load load = loadDao.getObject(loadId);

load.getSessions().remove(session);
session.getLoads().remove(load);
loadDao.saveObject(load);