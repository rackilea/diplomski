CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<User> criteria = builder.createQuery(User.class);
Root<User> user = criteria.from(User.class);
Root<Photo> photo = criteria.from(Photo.class);
List<Predicate> restrictions = new ArrayList<>();
restrictions.add(builder.equal(user.get("firstname"), user.getFirstName()));
restrictions.add(builder.equal(user.get("id"), photo.get("user")));

List<User> users = (List<User>) entityManager.createQuery(criteria).getResultList();