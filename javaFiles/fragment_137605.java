Random random = new Random();

        RealEstate RealEstate = em.createQuery("SELECT r FROM RealEstate r", RealEstate.class)
            .setFirstResult(random.nextInt(size))
            .setMaxResults(1) 
            .getSingleResult();