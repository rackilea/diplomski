for (int c = 1;c<204;c++) {

        try {
            mgr = getEntityManager();           
            theme = mgr.find(Theme2.class, "" + c);
            theme.calculatePopularity();

            mgr.persist(theme);


        } catch (Exception e) {

        } finally {
            mgr.close();
        }

    }