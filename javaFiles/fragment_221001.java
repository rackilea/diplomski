} catch (Exception e) {
        e.printStackTrace(); <--here logging or etc..
        if (tx != null) tx.rollback();
    } finally {
        session.close();
    }