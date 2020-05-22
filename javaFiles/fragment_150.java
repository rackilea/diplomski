CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery cq = cb.createQuery(Employee.class);
Root emp = cq.from(Employee.class);
Path<List<Project>> projects = emp.get("projects"));
cq.where(cb.isEmpty(projects));
cq.select(emp);