class FooController {
    def sessionFactory

    def doStuff = {
        List batch = new ArrayList()
        for (each person in legacy phone book) {
            // Construct new Grails domain class from legacy phone book person
            Person person = new Person(...)
            batch.add(person)
            if (batch.size() > 500) {
                Person.withTransaction {
                    for (Person p: batch)
                        p.save()
                    batch.clear()
                }
                // clear session here.
                sessionFactory.getCurrentSession().clear();
            }
        }
        // Save any remaining
        for (Person p: batch)
            p.save()
        }
    }
}