final BeanItemContainer<SimpleBean> container = new BeanItemContainer<>(SimpleBean.class);//create a container for beans
    container.addBean(new SimpleBean("Some string"));//add bean to the container
    container.addBean(new SimpleBean("Some string 123"));
    final ComboBox combo = new ComboBox("choose", container);/*create a combo box with caption "choose". the second argument is the datasource - this is the place from where the combo box will get its values.*/
    combo.setItemCaptionMode(ItemCaptionMode.ID);/*this will "tell" to combo box to use the container ids as values that must be showed in the combo box*/
    combo.setItemCaptionPropertyId("name");//"tell" to the combobox from which property of the container to get the values which must be displayed to the user
    combo.setImmediate(true);//this will generate browser request to the server immediate after user change the value of the combobox
    combo.addValueChangeListener(new ValueChangeListener()
    {

        @Override
        public void valueChange(ValueChangeEvent event)/*this method will be invoked when the combo box value was changed*/
        {

            System.out.println(combo.getValue());//this will return the selected object. 
        }
    });