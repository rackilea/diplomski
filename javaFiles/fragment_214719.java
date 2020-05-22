@Test
    public void test() {
        Child c = new Child();
        em.persist(c);

        Another a = new Another();
        a.setElement(c);
        Collection<Parent> col = new ArrayList<Parent>();
        col.add(c);
        a.setElementCollection(col);
        em.persist(a);
        c.setAnother(a);

        long idx = a.getId();
        tx.commit();

        // I'm cleaning the cache to be sure that call to a.getElement() will return proxy.
        em.clear();
        tx = em.getTransaction();
        tx.begin();

        a = em.find(Another.class, idx);
        Assert.assertNotNull(a);
        Parent p = a.getElement();
        // At this point p is a type of jpa.inheritance.issue.Parent_$$_javassist_1

        Assert.assertTrue(p instanceof Parent);
        Assert.assertFalse(p instanceof Child);

        // At this point a.elements is a not initialized (empty) collection of type org.hibernate.collection.PersistentBag
        // When we access this collection for the first time, records are read from the database 
        Assert.assertEquals(1, a.getElementCollection().size());

        if (p instanceof HibernateProxy) {
            p =
                    (Parent) ((HibernateProxy) p).getHibernateLazyInitializer()
                            .getImplementation();
        }

        // At this point p is a type of jpa.inheritance.issue.Child
        Assert.assertTrue(p instanceof Child);
    }

    @Entity
    public class Another {

        @JoinColumn(name = "element_id", referencedColumnName = "id", nullable = false)
        @ManyToOne(fetch=FetchType.LAZY)
        private Parent element; 
        public Parent getElement() {
            return element;
        }

        public void setElement(Parent element) {
            this.element = element;
        }

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "another", fetch = FetchType.LAZY)
        public Collection<Parent> elements;

        public Collection<Parent> getElementCollection() {
            return elements;
        }

        public void setElementCollection(Collection<Parent> elementCollection) {
            this.elements = elementCollection;
        }

        // @Id ...
    }

    @Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    public class Parent {
        @ManyToOne
        private Another another;

        public Another getAnother() {
            return another;
        }

        public void setAnother(Another another) {
            this.another = another;
        }

        // @Id ...
    }

    @Entity
    public class Child extends Parent {         
    }