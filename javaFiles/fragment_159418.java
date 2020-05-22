public class PortalUserRepository extends JpaRepository<PortalUser, Long> {

private EntityManagerFactory emf = null;

public PortalUserRepository() {
}

public PortalUserRepository(EntityManagerFactory emf) {
    this.emf = emf;
}

public EntityManager getEntityManager() {
    return emf.createEntityManager();
}

public void create(PortalUser entity) {
    if (entity.getUserTokens() == null) {
        entity.setUserTokens(new ArrayList<UserToken>());
    }
    EntityManager em = null;
    try {
        em = getEntityManager();
        em.getTransaction().begin();
        Collection<UserToken> attachedUserTokens = new ArrayList<UserToken>();
        for (UserToken userTokensUserTokenToAttach : entity.getUserTokens()) {
            userTokensUserTokenToAttach = em.getReference(userTokensUserTokenToAttach.getClass(), userTokensUserTokenToAttach.getId());
            attachedUserTokens.add(userTokensUserTokenToAttach);
        }
        entity.setUserTokens(attachedUserTokens);
        em.persist(entity);
        for (UserToken userTokensUserToken : entity.getUserTokens()) {
            PortalUser oldPortalUserOfUserTokensUserToken = userTokensUserToken.getPortalUser();
            userTokensUserToken.setPortalUser(entity);
            userTokensUserToken = em.merge(userTokensUserToken);
            if (oldPortalUserOfUserTokensUserToken != null) {
                oldPortalUserOfUserTokensUserToken.getUserTokens().remove(userTokensUserToken);
                oldPortalUserOfUserTokensUserToken = em.merge(oldPortalUserOfUserTokensUserToken);
            }
        }
        em.getTransaction().commit();
    } finally {
        if (em != null) {
            em.close();
        }
    }
}

public void edit(PortalUser entity) throws Exception {
    EntityManager em = null;
    try {
        em = getEntityManager();
        em.getTransaction().begin();
        PortalUser persistentPortalUser = em.find(PortalUser.class, entity.getId());
        Collection<UserToken> userTokensOld = persistentPortalUser.getUserTokens();
        Collection<UserToken> userTokensNew = entity.getUserTokens();
        List<String> illegalOrphanMessages = null;
        for (UserToken userTokensOldUserToken : userTokensOld) {
            if (!userTokensNew.contains(userTokensOldUserToken)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain UserToken " + userTokensOldUserToken + " since its entity field is not nullable.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        Collection<UserToken> attachedUserTokensNew = new ArrayList<UserToken>();
        for (UserToken userTokensNewUserTokenToAttach : userTokensNew) {
            userTokensNewUserTokenToAttach = em.getReference(userTokensNewUserTokenToAttach.getClass(), userTokensNewUserTokenToAttach.getId());
            attachedUserTokensNew.add(userTokensNewUserTokenToAttach);
        }
        userTokensNew = attachedUserTokensNew;
        entity.setUserTokens(userTokensNew);
        entity = em.merge(entity);
        for (UserToken userTokensNewUserToken : userTokensNew) {
            if (!userTokensOld.contains(userTokensNewUserToken)) {
                PortalUser oldPortalUserOfUserTokensNewUserToken = userTokensNewUserToken.getPortalUser();
                userTokensNewUserToken.setPortalUser(entity);
                userTokensNewUserToken = em.merge(userTokensNewUserToken);
                if (oldPortalUserOfUserTokensNewUserToken != null && !oldPortalUserOfUserTokensNewUserToken.equals(entity)) {
                    oldPortalUserOfUserTokensNewUserToken.getUserTokens().remove(userTokensNewUserToken);
                    oldPortalUserOfUserTokensNewUserToken = em.merge(oldPortalUserOfUserTokensNewUserToken);
                }
            }
        }
        em.getTransaction().commit();
    } catch (Exception ex) {
        String msg = ex.getLocalizedMessage();
        if (msg == null || msg.length() == 0) {
            Long id = entity.getId();
            if (findOne(id) == null) {
                throw new NonexistentEntityException("The entity with id " + id + " no longer exists.");
            }
        }
        throw ex;
    } finally {
        if (em != null) {
            em.close();
        }
    }
}

public void remove(Long key) throws IllegalOrphanException, NonexistentEntityException {
    EntityManager em = null;
    try {
        em = getEntityManager();
        em.getTransaction().begin();
        PortalUser portalUser;
        try {
            portalUser = em.getReference(PortalUser.class, key);
            portalUser.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The portalUser with id " + key + " no longer exists.", enfe);
        }
        List<String> illegalOrphanMessages = null;
        Collection<UserToken> userTokensOrphanCheck = portalUser.getUserTokens();
        for (UserToken userTokensOrphanCheckUserToken : userTokensOrphanCheck) {
            if (illegalOrphanMessages == null) {
                illegalOrphanMessages = new ArrayList<String>();
            }
            illegalOrphanMessages.add("This PortalUser (" + portalUser + ") cannot be destroyed since the UserToken " + userTokensOrphanCheckUserToken + " in its userTokens field has a non-nullable portalUser field.");
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        em.remove(portalUser);
        em.getTransaction().commit();
    } finally {
        if (em != null) {
            em.close();
        }
    }
}

public List<PortalUser> findAll() {
    EntityManager em = getEntityManager();
    try {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(PortalUser.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    } finally {
        em.close();
    }
}

public PortalUser findOne(Long key) {
    EntityManager em = getEntityManager();
    try {
        return em.find(PortalUser.class, key);
    } finally {
        em.close();
    }
}

public int count() {
    EntityManager em = getEntityManager();
    try {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<PortalUser> rt = cq.from(PortalUser.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    } finally {
        em.close();
    }
}

public PortalUser findPortalUserByUsername(String username){
    EntityManager em = getEntityManager();
    try {
        Query q = em.createQuery("select s from PortalUser s where s.username = '" + username + "'");
        return (PortalUser)q.getSingleResult();
    } finally {
        em.close();
    }
}