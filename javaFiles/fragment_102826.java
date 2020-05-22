@Override
    public CassandraSessionFactoryBean session() throws AnyOwnException {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        if (session != null) {
            session.setCluster(Objects.requireNonNull(cluster().getObject()));
            //do somthing else
        }

        throw new AnyOwnException("session is null inside CassandraSessionFactoryBean method");
        }