switch (this) {
   case UPLOAD_KEY_NOT_FOUND:
       return "Upload Key not found";
   case INVALID_UPLOAD_KEY:
       return "Invalid Upload Key";
   case SUCCESS:
       return "Success";
   default:
       return "No result code associated with: " + this.value;
 }