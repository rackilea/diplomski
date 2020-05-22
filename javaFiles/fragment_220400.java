FreeFormArrivalsThreadGroup freeFormArrivalsThreadGroup = new FreeFormArrivalsThreadGroup();
freeFormArrivalsThreadGroup.setName("Free Form Arrivals Thread Group");
PowerTableModel schedule = new PowerTableModel(new String[]{"Start", "End", "Duration"},
        new Class[]{Integer.class, Integer.class, Integer.class});
schedule.addRow(new Object[]{1, 10, 60});
freeFormArrivalsThreadGroup.setSamplerController(loopController);
freeFormArrivalsThreadGroup.setData(schedule);
freeFormArrivalsThreadGroup.setProperty(TestElement.TEST_CLASS, FreeFormArrivalsThreadGroup.class.getName());
freeFormArrivalsThreadGroup.setProperty(TestElement.GUI_CLASS, FreeFormArrivalsThreadGroupGui.class.getName());