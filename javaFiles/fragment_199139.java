//write the states
ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("path"));
Iterator<JCheckBox> i=checkBoxList.getIterator();
while(i.hasNext())
{
JCheckBox box=i.next();
oos.writeBoolean(box.isSelected());
}
oos.close();