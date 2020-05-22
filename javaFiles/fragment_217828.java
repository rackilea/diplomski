add(new DropDownChoice<String>("datumy", new Datumy()).add(
    new AjaxFormComponentUpdatingBehavior("onchange") {

        private static final long serialVersionUID = 1L;

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                       ...
        }
    }));