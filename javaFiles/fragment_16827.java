function edit(id) {
  jQuery.ajax({
    type: "GET",
    url: "getId",
    data: "id= " + id,
    datatype: "text",
    success: function(data) {
      console.log(data)
    }
  });
  var type = <%= ((String)request.getAttribute("myType"))%>;
  console.log("type is " + type);
}



@RequestMapping("/getId")
public @ResponseBody DataTypeOfReturn getId(
  @RequestParam int id, HttpServletRequest request) {
  int idBook = id; // add data type here to avoid java error
  System.out.println("get id book " + id);
  String type = BookDao.getTypeCategory(id);
  request.setAttribute("myType", type);
  System.out.println("request attribute" + request.getAttribute("myType"));
  return theValue; // value which you want to return
}