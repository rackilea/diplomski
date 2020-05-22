public boolean action(Event event, Object o)
  {
    if( event.target == save)
    {
        // SOLUTION IS HERE
        data=new Record();

          // TRACE
        // PROBLEM HERE: data keeps precedent value
        System.out.println("SAME PLAYER PLAY AGAIN: data.rollNo ACTUALLY:"+data.rollNo);

      rollNo = Integer.parseInt(roll.getText());

      // TRACE
      System.out.println("rollNo ACTUALLY:"+rollNo);

      if(rollNo<1)
      {
        roll.setText("Invalid Roll Num");
        return true;
      }
      try
      {
        file.seek((rollNo-1)*data.size());
        data.read(file);
      }
      catch( IOException e)
      {
          // TRACE
          System.out.println("EXCEPTION IN FILE !");

        // PROBLEM HERE: data have not been defined: then keeps precedent value

      }

      // TRACE
      System.out.println("data.rollNo ACTUALLY:"+data.rollNo);

      if(data.rollNo!=0)
      {
      // TRACE
       System.out.println("ALREADY EXISTS");


        roll.setText(String.valueOf(data.rollNo) + " already exists");
        fname.setText("");
        lname.setText("");
        stnd.setText("");
        addr.setText("");
      }

      if(data.rollNo==0)
      {
          // TRACE
          System.out.println("NOT FOUND");

     try
       {
        try
        {
          data.rollNo = rollNo;
          data.lastName = lname.getText();
          data.firstName = fname.getText();
          data.standard = Integer.parseInt(stnd.getText());
          data.address = addr.getText();
          file.seek((rollNo-1)*data.size());
          data.write(file);

          // TRACE
          System.out.println("WRITE DATA "+rollNo);
        }
        catch( IOException e)
        {
          roll.setText("Error Writing File" + e.toString());
          return true;
        }
      }

     // SOLUTION
     // WARNING: IF bad datas, 
        catch( Exception ex)
        {
            System.err.println("BAD DATAS");

             JOptionPane.showMessageDialog(new JFrame(),  "WARNING: all fields must be filled !", "WARNING",
                        JOptionPane.ERROR_MESSAGE);

          return true;
        }

        hide();

        // TRACE
        System.out.println("CLEAR");

        clear();

        // PROBLEM HERE: data not reset ! see above
      }
    }

    else if(event.target == cancel)
    {
      hide();
      clear();
    }
    return true;
  }