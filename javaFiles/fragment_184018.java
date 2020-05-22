QEvent qEvent = QEvent.event;

 JPAQuery query = new JPAQuery(entityManager);

 return query.from(qEvent)
                 .where(qEvent.active.eq(true)
                    .and(qEvent.sensorId.equalsIgnoreCase(sensorId)
                    .and(qEvent.timestamp.after(rangeStart)
                    .and(qEvent.timestamp.before(rangeEnd)))))
             .groupBy(qEvent.timestamp.dayOfYear())
             .list(new QTuple(qEvent.timestamp, Wildcard.count));