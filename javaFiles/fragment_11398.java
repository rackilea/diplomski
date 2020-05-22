Foo foo = findFoo(em);
Bar bar = findBar(em);

if (<condition>) {
    em.remove(foo);
    em.detach(bar); //If it is really necessary
    em.flush();
}

bar = findBar(em); //It will reattach the entity on the persistence context
bar.field = "updated value";

em.merge(bar); 
em.commit();