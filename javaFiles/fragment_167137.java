AjaxButton saveButton = new AjaxButton("saveButton") {
        @Override
        protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
            super.onSubmit(target, form);
            Map<String, Object> changedProperties = new HashMap<>();
            // for each entry in the dummy values linked via PropertyModel to the TextField input
            for (Map.Entry<String,Object> dummyEntry : getDummyProperties().entrySet()) {
                // for each entry in the
                for (Map.Entry<String,Object> realEntry : baseVertex.getProperties().entrySet()) {
                    // if the keys match
                    if (dummyEntry.getKey().equals(realEntry.getKey())) {
                        // if the value has changed
                        if (!dummyEntry.getValue().equals(realEntry.getValue())){

                            // value in textField differs from value in database
                            changedProperties.put(dummyEntry.getKey(),dummyEntry.getValue());
                        }
                    }
                }
            }

            DBWorker worker = new DBWorker();
            // perform the update
            worker.updateVertex(recordID, changedProperties);
            // pull the fresh vertex out and pass it to the page again
            setResponsePage(new VertexViewer(new PageParameters(), new CustomVertex(worker.getVertexByID(recordID))));
       }
};