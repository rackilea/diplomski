public void appendtempdate(String tempfile,String data)
 {
  try
  {
  File temp = new File(tempfile);
  if(!temp.exists())
  {
    temp.createNewFile();
  }
            FileWriter fw= new FileWriter(temp.getName(),true);
            BufferedWriter bw= new BufferedWriter(fw);
            bw.write(data);
            bw.close();
   }
    catch(Execption e)
    {
      }
    }