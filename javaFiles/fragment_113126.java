JsonObject jsonObject=new JsonObject();
   jsonObject.addProperty("groupId", groupid);
   jsonObject.addProperty("formId", formid);
   jsonObject.addProperty("fileExtension", "jpg");
   jsonObject.addProperty("fileName", sign_path.getName());
   jsonObject.addProperty("contentType", "image/jpg");
   jsonObject.addProperty("fileSize",sign_path.length());