public void getReference() throws IOException
{
    String line=null;

        connectRead("computer");
        //this is a method that reads a file in a format kevin kevin kevin kevin
        try
        {
            reference.add(new ArrayList<String>());
            int indexOfReferences =0 ;
            while ((line=bufferedReader.readLine())!=null)
            {
                st = new StringTokenizer(line); 

                for ( int i = 0 ; i < st.countTokens() ; i++)
                {       
                    reference.get(indexOfReferences).add(st.nextToken());
                }
               indexOfReferences++;

            }
            System.out.println(reference);

            bufferedReader.close();
        }
        catch ( IOException e )
        {
           System.out.println(e);
        }      

}