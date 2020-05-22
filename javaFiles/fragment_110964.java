From<RequestInfo> uploadFrm = new Form<RequestInfo>("uploadFrm", getModel());   
AjaxSubmitLink ajaxSubmitLink = new AjaxSubmitLink("ajaxSubmitLink", uploadFrm) {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
               target.appendJavaScript("you javascript");                          
            }

        };

        uploadFrm.add(ajaxSubmitLink);