String[] tags = {"ADMIN", "EMPLOYEE"};
String hql = "select u from User u " +
                "join u.roles r " +
                "where r.name in (:tags)" +
                "group by u " +
                "having count(r)=:tag_count";
Query query = session.createQuery(hql);
query.setParameterList("tags", tags);
query.setInteger("tag_count", tags.length);
List<User> Users = query.list();