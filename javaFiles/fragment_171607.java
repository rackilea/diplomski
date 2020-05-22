@NamedQueries({
@NamedQuery(
    name="SimplePerson.findByName", 
    query="select p from SimplePerson p where p.name = :name", 
    hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true") })
})