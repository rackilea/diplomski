public static void updateGui(TaskPane tp, TaskList tl) { 
    tp.removeAll();
    for (int x = 0; x <= tl.getTaskCount(); x++){
        tp.add(new JCheckBox(tl.getTask(x).getName()));
    }
    tp.setVisible(true); 
}