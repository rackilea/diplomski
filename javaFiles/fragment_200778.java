BindingGroup context = new BindingGroup();
    BeanProperty valuesProperty = BeanProperty.create("suggestionList");

    JTableBinding tableBinding = SwingBindings.createJTableBinding(
            UpdateStrategy.READ_WRITE,
            sourceBean, valuesProperty,
            table);
    context.addBinding(tableBinding);
    tableBinding.addColumnBinding(BeanProperty.create("firstName"));
    tableBinding.addColumnBinding(BeanProperty.create("lastName"));
    context.bind();

    // add a button which changes the suggestionList 
    Action next = new AbstractAction("new data") {

        public void actionPerformed(ActionEvent e) {
            sourceBean.setSuggestionList(createRandomData());
        }

    };
    button.setAction(next);