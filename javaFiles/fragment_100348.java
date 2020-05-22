final Person object = new Person(id, name, password);
    hibernateTemplate.execute(new HibernateCallback<Person>() {

        public Person doInHibernate(Session session)
                throws HibernateException {

            session.save(object);
            session.flush();
            return object;
        }
    });