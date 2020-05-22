try {
            CriteriaImpl c = (CriteriaImpl) criteria;
            SessionImpl s = (SessionImpl) c.getSession();
            SessionFactoryImplementor factory = (SessionFactoryImplementor) s.getSessionFactory();
            String[] implementors = factory.getImplementors(c.getEntityOrClassName());
            CriteriaLoader loader = new CriteriaLoader((OuterJoinLoadable) factory.getEntityPersister(implementors[0]),
                    factory, c, implementors[0], s.getEnabledFilters());
            Field f = OuterJoinLoader.class.getDeclaredField("sql");
            f.setAccessible(true);
            String sql = (String) f.get(loader);
        } catch (Exception e) {
        }