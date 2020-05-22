final String query = "SELECT e FROM Event e WHERE e.category.name = :categoryName";

final String categoryName = ...;
TypedQuery<Event> query = entityManager.createQuery(query, Event.class);
query.setParameter("categoryName", categoryName);
final List<Event> events = query.getResultList();