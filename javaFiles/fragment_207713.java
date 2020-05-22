Map<ExperimentRecord, Result<Record>> map =
DSL.using(configuration)
   .select()
   .from(EXPERIMENT)
   .join(TAGS)
   .on(...)
   .fetchGroups(EXPERIMENT);