@Override
    protected void onSubmit(AjaxRequestTarget target, Form<?> form)
    {               
        String value=(String)txtName.getModelObject();
-->        dp.setName(value);
        target.addComponent(wmc);
    }