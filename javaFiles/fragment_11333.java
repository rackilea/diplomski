criteria.setProjection(
     Projections.projectionList()
    .add(Projections.min("price"))
    .add(Projections.max("price"))
);
Object[] minMax = criteria.uniqueResult();
Integer min = (Integer) minMax[0];
Integer max = (Integer) minMax[1];