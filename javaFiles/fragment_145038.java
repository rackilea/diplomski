public class DuckDuckGoose
{

    private FileReader fr;
    private Scanner sc;

    public static void main(String[] args)
    {



        List<String> ll = new LinkedList<String>();
        ListIterator<String> iter = ll.listIterator();

        DuckDuckGoose ddg = new DuckDuckGoose();
        ddg.openFile("R.txt",ll);


    }

    /**
     * openFile  method to open the file, then invokes the method that reads it
     *
     * @param fileName name
     * @param ll
     * @throws FileNotFoundException
     */
    public void openFile(String fileName, List<String> ll)
    {
        try
        {
            fr = new FileReader(fileName);
            sc = new Scanner(fr);
            readAndSOPFile(ll);
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File not Found");
        }
        catch (NoSuchElementException nsee)
        {
            System.out.println("No such element was found");
        }
        catch (Exception e)
        {
            System.out.println("An exception occurred");
        }
        finally
        {
            try
            {
                fr.close();
                sc.close();
            }
            catch (IOException ioe)
            {
                System.out.println("Cannot close the output file");
            }
            catch (NullPointerException npe)
            {
                System.out.println("File was not created correctly");
            }
            catch (Exception e)
            {
                System.out.println("An error occurred");
            }

        }
    }

    /**
     * readAndSOPFile reads each token and prints it to the console on a single line
     * @throws IllegalStateException
     * @throws NoSuchElementException
     */
    public void readAndSOPFile(List<String> list) throws IllegalStateException, NoSuchElementException
    {
        while (sc.hasNext())
        {
            String s = sc.next();
            list.add(s);
            System.out.println(s);
        }
    }

}