ListBoxBEvent.register(eventBus, new ListBoxBEvent.Handler() {
            @Override
            public void onListBoxBChanged (ListBoxBEvent listBoxBEvent) {
                Object seletetObject =  listBoxBEvent.getSelectedObject();
                updateListBoxB(seletetObject);
            }           
        });