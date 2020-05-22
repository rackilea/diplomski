AjaxFallbackDefaultDataTable table =
            new AjaxFallbackDefaultDataTable("table", null, null, FLAG_RESERVED1) {
        @Override
        protected Item newCellItem(String id, int index, IModel model) {
            Item item;
            if (index == indexOfColumnYouWant){
                item = new Item(id, index, model) {
                    @Override
                    public void onEvent(IEvent<?> event) {
                        super.onEvent(event); 
                        if ((event.getPayload() instanceof AjaxUpdateEvent) ){
                            ((AjaxRequestTarget)event.getPayload()).add(item);
                        }
                    }
                };
            } else {
                item = super.newCellItem(id, index, model);
            } 

            return item;
        }
    };