String file = request.getParameter("text");
String fileNoExt, fileExt = "";
if(file.indexOf(".") == -1) {
   fileNoExt = file;
else {
   fileNoExt = file.substring(0,file.lastIndexOf("."));
   fileExt  = file.substring(file.lastIndexOf(".")+1);
}