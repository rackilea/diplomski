List<Profile> followers=JPA.em().createQuery(
    "select p from " + Profile.class.getName() + " p " + 
    "join p.fansFollowed f where f.id = :id")
    .setParameter("id", profile.id)
    .getResultList();
for (Profile follower : followers) {
    follower.fansFollowed.remove(profile);
    follower.save();
}
profile.delete();