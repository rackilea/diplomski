Query q1 = em.createQuery("SELECT t.name, t.salary FROM BusinessProcessTable t");
        List<Object[]> result1 = q1.getResultList();
        for (Object[] resultElement : result1) {
            String name = (String)resultElement[0];
            Double salary = (Double)resultElement[1];
            ...
        }