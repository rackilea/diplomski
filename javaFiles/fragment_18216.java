if($("div select[name=responseContentType]", $(this.el)).val() === undefined) { 
    opts.responseContentType = opts.parent.model.produces[0];
}

else {
    opts.responseContentType = $("div select[name=responseContentType]", $(this.el)).val();
}