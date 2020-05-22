public class Main
{
     public static void main(String[] args)
     {
         if(args.length < 2) 
         {
             System.exit(0);
         }
         String ignoreStartWord = args[0];
         String ignoreEndWord = args[1];
         BufferedReader br = null;
         BufferedWriter bw = null;
         try
         {
             br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("fileName"))));
             bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("fileName2"))));
             boolean ignoreStarted = false;
             String line = null;
             while((line = br.readLine()) != null)
             {
                 if(ignoreStarted == false)
                 {
                     if(line.equals(ignoreStartWord))
                     {
                         ignoreStarted = true;
                     }
                     else
                     {
                         bw.write(line);
                         bw.newLine();
                     }
                 }
                 else
                 {
                     if(line.equals(ignoreEndWord))
                     {
                         ignoreStarted = false;
                     }
                 }
            }
        }
        catch(IOException e)
        {
             e.printStackTrace();
        }
        catch(FileNotFoundException e)
        {
             e.printStackTrace();
        }
        finally
        {
             if(br != null) try { br.close(); } catch(IOException e) {}
             if(bw != null) try { bw.close(); } catch(IOException e) {}
        }
    }
}