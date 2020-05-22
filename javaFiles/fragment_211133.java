GuiPackage guiInstance = GuiPackage.getInstance();

TestElement testElement = guiInstance.createTestElement("org.apache.jmeter.XXXX.XXX.GUI_CLASS");

testElement.setName("TEST ELEMENT NAME");

JMeterTreeNode parentNode = guiInstance.getCurrentNode();

JMeterTreeNode node = guiInstance.getTreeModel().addComponent(testElement, parentNode);

guiInstance.getMainFrame().getTree().setSelectionPath(new TreePath(node.getPath())); 
guiInstance.updateCurrentGui();