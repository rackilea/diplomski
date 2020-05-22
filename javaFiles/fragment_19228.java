$("iframe.cke_dialog_ui_input_file")
  .delay(100, 
    lazy()
      .contents().find("body")
        .css("font-name", "verdana")
        .css("font-size", "x-small")
    .done());