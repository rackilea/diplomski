// first one to select Log objects
String logQuery = "SELECT l FROM Log l WHERE l.actionType = :actionType";
...
List<Log> logs = logJpaQuery.getResultList();

// second one to select distinct users from this objects
String usersQuery = "SELECT distinct l.user FROM Log l where l.logId in (:logIds)";
...
userJpaQuery.setParameter("logIds", logs);
List<User> users = userJpaQuery.getResultList();