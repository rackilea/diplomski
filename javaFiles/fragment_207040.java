BufferedWriter out = new BufferedWriter(
   new OutputStreamWriter(
              new FileOutputStream(file), "UTF16"));
  int size=1;
  for(Tableclass variable:tablevector)
  {
        out.write(String.valueOf(size));
        out.newLine();
        out.write(variable.Starttime);
        out.write(" --> ");
        out.write(variable.Endtime);
        out.newLine();
        out.write(variable.Text);
        out.newLine();
        out.newLine();
      // output.format("%d\n%s --> %s\n%s\n\n",size,variable.Starttime,variable.Endtime,variable.Text);

    size++;

  }
  out.close();