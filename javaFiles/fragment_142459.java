Job content = new Job();
JobConfiguration cfg = new JobConfiguration();
JobConfigurationQuery jobConfigurationQuery = new JobConfigurationQuery();
UserDefinedFunctionResource userDefinedFunctionResource = new UserDefinedFunctionResource();
userDefinedFunctionResource.setResourceUri("gs://mybucket/udf.js");
jobConfigurationQuery.setUserDefinedFunctionResources(Lists.newArrayList(
    userDefinedFunctionResource
));
cfg.setQuery(jobConfigurationQuery);
content.setConfiguration(cfg);
Bigquery.Jobs.Insert request = bigqueryService.jobs().insert(projectId, content);
Job response = request.execute();