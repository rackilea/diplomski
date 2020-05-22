List<List<FormFieldsDO>> formFieldList=new ArrayList<List<FormFieldsDO>>();
for(int i = 0 ;i< partialReportDO.getWorkFlowList().size(); i++ ){
    List<FormFieldsDO> listOfFormField =  formServices.getFieldListByWorkFlowId(partialReportDO.getWorkFlowList().get(i),
                        partialReportDO.getFieldIds());
    formFieldList.add(listOfFormField);
}

map.addAttribute("formFieldList", formFieldList);