List<Department> deps = em.get().createQuery(
            "select distinct d " +
                    "from Department d " +
                    "order by d.id desc ", Department.class)
            .setFirstResult(first)
            .setMaxResults(count)
            .getResultList();

    List<Object[]> tuple = em.get().createQuery(
            "select d, substring(d.content.htmlBody, 1,400)" +
                    "from Department d " +
                    "left join fetch d.employees" +
                    "where d in (:deps) order by d.id desc")
            .setParameter("deps", deps)
            .getResultList();

    ... //Filter the duplicates due to the fetching