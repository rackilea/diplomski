criteria.setProjection(Projections.projectionList()
  .add(Projections.property("f.name").as("name"))
  .add(Projections.property("fv.versionName").as("versionName"))
  .add(Projections.property("d.startDate").as("startDate"))
  .add(Projections.property("d.endDate").as("endDate"))
  .add(Projections.property("fv.featureVersionId").as("featureVersionId")));
criteria.setResultTransformer(Transformers.aliasToBean(FeatureSearchResult.class));