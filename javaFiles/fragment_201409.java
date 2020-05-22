for(int i=0;i<7;i++)
    {
TableRow tr1=new TableRow(this);
    EditText ed7=new EditText(inventory.this); 
      ed7.setTextColor(Color.BLACK);     
       String s=new Integer(i).toString();      //convert the integer into String   
       ed7.setText(s); 
tr1.addView(ed7);
 <TableLayoutName>.addview(tr1);
    }