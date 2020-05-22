@Actions({
  @Action ("ExportGrid"), //Result will be set as stream
  @Action ("ShowGrid") // Result will be set to JSON
})
@validation ( @Required ..... // Validation Rules for fromDate toDate etc
public String doGrid(){
  grid = serviceFacade.getGrid(fromDate,toDate);
  if (ActionContext.getContext().getName().equals("ExportGrid")
    inputStream = convertGridToStream(grid); // By using jasper report or other tools
  return SUCCESS;
}