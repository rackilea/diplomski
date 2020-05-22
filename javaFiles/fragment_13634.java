JsonArray array = new JsonArray();

try (Session session = factory.openSession()) {
    String hql = "FROM Personalisation E WHERE E.userId = "+id;
    Query query = session.createQuery(hql);
    List<?> results = query.list();

    for(int i = 0; i < results.size(); i++) {
        JSONObject obj = new JSONObject();

        Persona p = (Person) results.get(i);
        System.out.println(p.getCourseId());
        obj.put("courseId", p.getCourseId());
        obj.put("CourseValue", (JSONObject) new  JSONParser().parse(p.getCourseValue()));

        array.add(obj);
    }
} catch (Exception e) {
    e.printStackTrace();
}

return array;