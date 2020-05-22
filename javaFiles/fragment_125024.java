Rpc.test(attribute, new AsyncCallback<Boolean>() {

        @Override
        public void onSuccess(Boolean result) {
            // here is the result
            if(result){
                    // yes the attribute was setted
               }
        }

        @Override
        public void onFailure(Throwable caught) {
            Window.alert(caught.getMessage());

        }
    });