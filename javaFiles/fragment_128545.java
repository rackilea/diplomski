JComboBox<String> cb = new JComboBox<>(new String[] {"Stack", "Over", "Flow"});
 cb.addItemListener(new ItemListener() {
     @Override
     public void itemStateChanged(ItemEvent e) {
         System.out.println("Change");
     }
 });