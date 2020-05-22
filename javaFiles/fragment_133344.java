if(fileExt.equals("jpg") || fileExt.equals("jpeg") ||fileExt.equals("png") || 
   fileExt.equals("ico"))
  out.println("Content type: image/" + fileExt);
else
  out.print("Content type: text/");
if(fileExt.equals("html"))
  out.println(fileExt);
else
  out.println("plain");