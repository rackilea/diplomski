.createAlias("this.consultation", "c")
.setProjection(Projections.distinct(
Projections.projectionList()
.add(Projections.property("this.id"))
.add(Projections.property("this.creationDate"))
.add(Projections.property("c.institution"))

...

crit.addOrder(org.hibernate.criterion.Order.desc("c.institution"));