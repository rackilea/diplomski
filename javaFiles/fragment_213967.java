KeyAdapter adapter = KeyAdapter()
{  
  public void keyReleased(java.awt.event.KeyEvent evt) 
          {  
            super.keyReleased(evt);
            if (tfFirst.getText().trim.length() > 0 && tfLast.getText().trim.length() > 0) 
            {  
                bAdd.setEnabled(true);  
            } else 
            {  
                bAdd.setEnabled(false);  
            }  
        }  
};
tfLastName.addKeyListener(adapter);
tfFirstName.addKeyListener(adapter);