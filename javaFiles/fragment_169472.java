query.from(catalog)
.innerJoin(qe).on(catalog.id.eq(qe.itemId))
.innerJoin(enterprise).on(enterprise.id.eq(qe.enterpriseId))
.leftJoin(catalogPerson).on(catalogPerson.catalogId.eq(catalog.id))
.where(catalog.deletionDate.isNull(), qe.enterpriseId.eq(org))
.orderBy(catalog.creationDate.desc())
.limit(limit)
.offset(offset)
.groupBy(catalog.id)
.list(Projections.constructor(Catalog.class,
                            catalog.id,
                            catalog.name,
                            catalog.code,
                            catalogPerson.count()));