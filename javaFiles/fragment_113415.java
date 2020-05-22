Query q = em.createNativeQuery(
    "SELECT c.id, c.name, COUNT(o) as orderCount, AVG(o.price) AS avgOrder " +
    "FROM Customer c " +
    "JOIN Orders o ON o.cid = c.id " +
    "GROUP BY c.id, c.name",
    "CustomerDetailsResult");

@SqlResultSetMapping(name="CustomerDetailsResult",
    classes={
    @ConstructorResult(targetClass=com.acme.CustomerDetails.class,
        columns={
            @ColumnResult(name="id"),
            @ColumnResult(name="name"),
            @ColumnResult(name="orderCount"),
            @ColumnResult(name="avgOrder", type=Double.class)})
})