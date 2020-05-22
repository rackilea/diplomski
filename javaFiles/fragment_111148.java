import static com.google.gwt.query.client.GQuery.*;
[...]

final FileUpload fileUpload = new FileUpload();
RootPanel.get().add(fileUpload);

$(fileUpload)
  // FileUpload does not have a way to set the multiple attribute,
  // we use gQuery instead
  .prop("multiple", true)
  // We use gQuery events mechanism
  .on("change", new Function() {
    public void f() {
      // Use gQuery utils to create a FormData object instead of JSNI
      JavaScriptObject form = JsUtils.runJavascriptFunction(window, "eval", "new FormData()");
      // Get an array with the files selected
      JsArray<JavaScriptObject> files =  $(fileUpload).prop("files");
      // Add each file to the FormData
      for (int i = 0, l = files.length(); i < l; i++) {
        JsUtils.runJavascriptFunction(form, "append", "file-" + i, files.get(i));
      }

      // Use gQuery ajax instead of RequestBuilder because it 
      // supports FormData and progress
      Ajax.ajax(Ajax.createSettings()
                    .setUrl(url)
                    .setData((Properties)form))
        // gQuery ajax returns a promise, making the code more declarative
        .progress(new Function() {
          public void f() {
            double total = arguments(0);
            double done = arguments(1);
            double percent = arguments(2);
            // Here you can update your progress bar
            console.log("Uploaded " + done + "/" + total + " (" + percent + "%)");
          }
        })
        .done(new Function() {
          public void f() {
            console.log("Files uploaded, server response is: " + arguments(0));
          }
        })
        .fail(new Function() {
          public void f() {
            console.log("Something went wrong: " + arguments(0));
          }
        });
    }
});