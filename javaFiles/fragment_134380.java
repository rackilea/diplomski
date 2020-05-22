public class AgentLicenseLazyModel extends CoreDataModel<AgentLicenseModel> {
    public AgentLicenseLazyModel(final List<AgentLicenseModel> entities) {
        super(AgentLicenseModel.class, entities, new CoreDataSorterProducer<AgentLicenseModel> () {

            public AgentLicenseLazySorter theMethodName (TheTypeOfSortField sortField, TheTypeOfSortOrder sortOrder) 
            {
                return new AgentLicenseLazySorter(sortField, sortOrder);
            }
        });
    }
}