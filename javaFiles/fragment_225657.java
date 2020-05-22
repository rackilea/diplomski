List<Map<String,Object>> opportunityParameterList = new ArrayList<>();
Map<String, Object> opportunityParameters = new HashMap<>();      
opportunityParameters.put("name", opportunityDaoModel.getTopic());
opportunityParameters.put("lookupfield@odata.bind", "/lookupentityendpoint("+opportunityDaoModel.getProgress()+")");
opportunityParameterList.add(opportunityParameters);
this.crmHelper.updateAttribute("opportunities", opportunityDaoModel.getCrmguid(), opportunityParameterList);