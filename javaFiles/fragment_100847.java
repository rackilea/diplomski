public final native void readAsDataURL(MyClass that, FileUpload input) /*-{
     var files = input.@com.google.gwt.user.client.ui.FileUpload::getElement()().files;
     var reader = new FileReader();  
     reader.onload = function (evt) {
         that.@...MyClass::done(Ljava/lang/String;)(evt.target.result);
     }
     reader.readAsDataURL(files[0]);
    }-*/;