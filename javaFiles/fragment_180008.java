private String ckValue ;

CkEditor ckeditor = new CkEditor(new CkConfig());
ckeditor.addAttachHandler(new AttachHandler(){
       public void onAttach(Event value){
             setCkValue(value);
       }
});

public void setCkValue(String ckValue){
      this.ckValue = ckValue;
}

public String getCkValue(){
      return ckValue;
}