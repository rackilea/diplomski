@PersistenceContext
    private val entityManager: EntityManager? = null

    fun count(request: HttpServletRequest): Long {
        val query = entityManager!!.createQuery("SELECT COUNT(resume.id) FROM Resume resume")
        return query.singleResult as Long
    }