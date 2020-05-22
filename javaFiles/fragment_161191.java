public abstract class MultiTextPanel<T> extends Panel {

public MultiTextPanel(String id, IModel<ArrayList<T>> model) {
    super(id, model);

    final Form<ArrayList<T>> multiTextForm = new Form<ArrayList<T>>("multiTextForm", model);
    add(multiTextForm);

    final ListView<T> listView = new ListView<T>("listView", model) {

        @Override
        protected void populateItem(final ListItem<T> item) {
            // TODO Auto-generated method stub
            TextField<T> textField = new TextField<T>("textField", item.getModel());
            add(textField);

            AjaxSubmitLink removeButton = new AjaxSubmitLink("removeButton", multiTextForm) {

                @Override
                protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                    multiTextForm.getModelObject().remove(item.getModelObject());
                    target.addComponent(multiTextForm);
                }

                @Override
                protected void onError(AjaxRequestTarget target, Form<?> form) {
                    //errors should be ignored, we shoudlnt validate in our form, so this shouldnt happen anyway
                    multiTextForm.getModelObject().remove(item.getModelObject());
                    target.addComponent(multiTextForm);
                }

            };              
            add(removeButton);

        }

    };
    add(listView);

    AjaxSubmitLink addButton = new AjaxSubmitLink("addButton", multiTextForm) {

        @Override
        protected void onError(AjaxRequestTarget target, Form<?> form) {
            //errors should be ignored, we shoudlnt validate in our form, so this shouldnt happen anyway
            multiTextForm.getModelObject().add(createNewT());
            target.addComponent(multiTextForm);
        }

        @Override
        protected void onSubmit(AjaxRequestTarget target, Form form) {
            multiTextForm.getModelObject().add(createNewT());
            target.addComponent(multiTextForm);
        }
    };
    add(addButton);



}

public abstract T createNewT();}