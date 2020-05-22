IWorkspaceConnection stream; //is not null, already instantiated somewhere else
IBaselineSet bl0 = (IBaselineSet) 
    itemManager.fetchCompleteItem(baseLineHandle0, IItemManager.DEFAULT, monitor);
IBaselineSet bl1 = (IBaselineSet)
    itemManager.fetchCompleteItem(baseLineHandle1, IItemManager.DEFAULT, monitor);
IChangeHistorySyncReport report = 
    workspaceManager.compareBaselineSets(bl0, bl1, getComponentHandles(stream), monitor);