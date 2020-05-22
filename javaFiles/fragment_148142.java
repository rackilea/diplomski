AxisConfiguration axisConfiguration = _messageContext.getConfigurationContext().getAxisConfiguration();
ArrayList arrayList = new ArrayList();
arrayList.add(new MustUnderstandHandler());
axisConfiguration.setInPhasesUptoAndIncludingPostDispatch(arrayList);

// execute the operation client
_operationClient.execute(true);