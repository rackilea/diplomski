FacesContext context = FacesContext.getCurrentInstance();
ExternalContext externalContext = context.getExternalContext();
externalContext.responseReset(); 
externalContext.setResponseContentType("application/vnd.ms-excel");
externalContext.setResponseHeader("Content-Disposition", "attachment;filename=export.xls");
workbook.write(externalContext.getResponseOutputStream());
context.responseComplete(); // Prevent JSF from performing navigation.