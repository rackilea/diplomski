while (iter.hasNext()) {
    // Code
}
FilterData fd = new FilterData();
String data = fd.getData(uploadPath + "//" + fileName);
request.setAttribute("message", data);