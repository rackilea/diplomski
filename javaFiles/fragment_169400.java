@Override
public void onClick(DialogInterface dialog, int indexSelected,boolean isChecked) 
{
    if (isChecked) { 
     selectedItems.add(indexSelected);

    //WHERE I WANT TO REFERENCE WHICH CHECKBOX IS CLICKED
    switch (indexSelected)
    {
         case 0:
            // do something if the first box is checked
            break;
         case 1:
            // do something if the second box is checked
            break;
         ...
    }
}