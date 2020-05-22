@Query("select count(p) from User u join u.posts p where u.id = ?1")
long countPosts(Long id);

@Query("select count(f) from User u join u.followers f where u.id = ?1")
long countFollowers(Long id);

@Query("select count(f) from User u join u.followings f where u.id = ?1")
long countFollowings(Long id);