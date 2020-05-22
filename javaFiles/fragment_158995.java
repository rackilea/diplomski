StringBuffer sql = new StringBuffer();  
sql.append("select NEW model.ObjectPR(p.name as name, s.level as level)
from 
Person p join p.student s");


Query query = getSession().createQuery(sql.toString());

List<ObjectPR> results = query.list();