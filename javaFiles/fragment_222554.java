BeanItemContainer<Car> cont = new BeanItemContainer<>(Car.class);
cont.addItem(new Car("Z"));
cont.addItem(new Car("B"));
cont.addItem(new Car("Y"));
cont.addItem(new Car("A"));

cont.sort(new Object[] {"name"}, new boolean[] {true});
comboBox_sort.setContainerDataSource(cont);