public static void main(String[] args)
{
    System.out.println(String.format("%-10s%-10s%-10s", "sum", "even",
            "odd"));
    try
    {
        // The maintained sum list
        List<Sum> sumList = new ArrayList<Sum>();
        InputStream fstream = new FileInputStream("data.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null)
        {
            // Prepare to insert a new sum object
            Sum newSum = new Sum();
            String[] numberStrs = strLine.split("\t");
            for (String numberStr : numberStrs)
            {
                // The sum object manages its own tallies
                newSum.addNumber(Integer.parseInt(numberStr));
            }
            // Append the new object to the list
            sumList.add(newSum);
        }
        in.close();
        // Sort the list
        Collections.sort(sumList);

        // Print the list
        for (Sum sum : sumList)
        {
            /*
             * The sum object is responsible for generating its own string 
             * representation
             */
            System.out.println(sum);

        }
    }
    catch (Exception e)
    {
        // Catch exception if any
        System.err.println("Error: " + e.getMessage());
    }

}