PMML pmml = ...
RegressionModelManager regressionManager = new RegressionModelManager(pmml);
RegressionModel model = regressionManager.getModel();
List<RegressionTable> modelTables = model.getRegressionTables();
for(RegressionTable regressionTable : regressionTables){
  ...
}