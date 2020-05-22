downloadBehavior = new AbstractAjaxBehavior()
        {
            private static final long serialVersionUID = 3472918725573624819L;

            @Override
            public void onRequest()
            {
                [...]                   
                ResourceStreamRequestHandler handler = new ResourceStreamRequestHandler(
                        AjaxDownloadLink.this.getModelObject(), name);
                handler.setContentDisposition(ContentDisposition.ATTACHMENT);
                getComponent().getRequestCycle().scheduleRequestHandlerAfterCurrent(handler);
            }
        };