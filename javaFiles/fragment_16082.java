String[] items = {"item 1","item 2"," item 3","item 4"};
JComboBox combo = new JComboBox(items)
combo.addItemListener(new ItemListener(){
public void itemStateChanged(ItemEvent ie)
{
   if(ie.getStateChange() == ItemEvent.DESELECTED) //edit: bracket was missing
   {
      System.out.println("Previous item: " + ie.getItem()); //edit: bracket was missing
   }
   else if(ie.getStateChange() == ItemEvent.SELECTED)
   {
      System.out.println("Current \ New item: " + ie.getItem());
   }
}