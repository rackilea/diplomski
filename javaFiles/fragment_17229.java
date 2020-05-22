// a custom action doing the toggle
public static class ToggleSelection extends AbstractAction {

    public ToggleSelection(String id) {
        putValue(ACTION_COMMAND_KEY, id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container parent = (Container) e.getSource();
        AbstractButton child = findButton(parent);
        if (child != null) {
            child.setSelected(!child.isSelected());
        }
    }

    private AbstractButton findButton(Container parent) {
        String childId = (String) getValue(ACTION_COMMAND_KEY);
        for (int i = 0; i < parent.getComponentCount(); i++) {
            Component child = parent.getComponent(i);
            if (child instanceof AbstractButton && childId.equals(child.getName())) {
                return (AbstractButton) child;
            }
        }
        return null;
    }

}

// register with the checkbox' parent
for (int i=1;i<11;i++)  {
       String id = "key_" + i;
       boxy[i]=new JCheckBox();
       boxy[i].setName(id);
       pnlOdpovede.getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
           .put(KeyStroke.getKeyStroke((char) i), id);  
       pnlOdpovede.getActionMap().put(id, new ToggleSelection(id));
       pnlOdpovede.add(boxy[i]);
 }