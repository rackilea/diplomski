MutableIssue issuePattern = ComponentAccessor.getComponentOfType(IssueFactory.class).getIssue();
    issuePattern.setProjectId(projectId);
    issuePattern.setIssueTypeId(issueTypeId);

    IssueCreationHelperBean issueCreationHelperBean = ComponentAccessor.getComponentOfType(IssueCreationHelperBean.class);
    List<OrderableField> availableFields = issueCreationHelperBean.getFieldsForCreate(loggedInUser, issuePattern);