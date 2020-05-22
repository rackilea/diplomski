...
Map<String, Object> parameters = new HashMap<String, Object>();
newpdftemplate newpdftemplate = new newpdftemplate();
ArrayList<usingbean> dataBeanList = newpdftemplate.getDataBeanList();
JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
parameters.put("subReportDataSource", beanColDataSource);
...