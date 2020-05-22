auditableClient = &#40;IAuditableClient&#41; repository.getClientLibrary&#40;IAuditableClient.class&#41;;

IQueryClient queryClient = &#40;IQueryClient&#41; repository.getClientLibrary&#40;IQueryClient.class&#41;;



IQueryableAttribute attribute = QueryableAttributes.getFactory&#40;IWorkItem.ITEM_TYPE&#41;.findAttribute&#40;currProject, IWorkItem.PROJECT_AREA_PROPERTY, auditableClient, null&#41;;

Expression expression = new AttributeExpression&#40;attribute, AttributeOperation.EQUALS, currProject&#41;;

IQueryResult&lt;IResolvedResult&lt;IWorkItem&gt;&gt; results = queryClient.getResolvedExpressionResults&#40;currProject, expression, IWorkItem.FULL_PROFILE&#41;;