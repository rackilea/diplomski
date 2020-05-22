entityManager
.createQuery("
    select t
    from Tag t
    where t.name != 'tag3'
    and t.item in (select t2.item from Tag t2 where t2.name = 'Tag3')
    and t.item.name = :name")
.setParateter("name", "foo")
.getResultList();