@Override
public void itemStateChanged(ItemEvent event)
{
    String choice = event.getItem().toString();
    selection.setText("chose" + choice);
}