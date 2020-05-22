IWorkItem workItem = workItemClient.findWorkItemById(id, IWorkItem.SMALL_PROFILE, monitor);
    IDetailedStatus status = workItemClient.deleteWorkItem(workItem, monitor);

    if (!status.isOK()) {
            throw new TeamRepositoryException("Error deleting work item",
                    status.getException());
    }

    System.out.println("Deleted work item: " + idString + ".");