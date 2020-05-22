List<Cars> list=entityManager.createQuery("Put any of the above statements", Cars.class)
                .setParameter("d1", new Date("2015/05/04"))
                .setParameter("d2", new Date("2015/05/04"))
                .setParameter("d3", new Date("2015/05/06"))
                .setParameter("d4", new Date("2015/05/06"))
                .setParameter("d5", new Date("2015/05/04"))
                .setParameter("d6", new Date("2015/05/06"))
                .getResultList();