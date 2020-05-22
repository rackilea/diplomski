public int[] ReadFromFile(final String[] tokens) throws IOException
{

    final int[] counters = new int[tokens.length];
    BufferedReader br;
    br = new BufferedReader(new FileReader("D:/test.txt"));
    String str1 = "";

    while ((str1 = br.readLine()) != null)
    {
        for (int i = 0; i < tokens.length; i++)
            if (str1.contains(tokens[i]))//if the line contains the token
                counters[i]++;// increase counter for the index of the token

    }

    return counters;
}

...


public void actionPerformed(ActionEvent arg0)
{
    //final String[] tokens = new String[] { "Vlad Enache", "dog", "cat" };
    final String[] tokens = textField.getText().split(", ");//get token directly from JTextfield.
   // Would make more sense to use a different JtextField for input and output. 
   //This is just an example
    try
    {
        int[] count;
        count = ReadFromFile(tokens);

        final StringBuilder sb = new StringBuilder();//storing the result in a stringbuilder

        /* to display the utterance of each token 
        for (int i = 0; i < count.length; i++)
            sb.append(tokens[i] + " is repeated " + count[i] + " times\n");

        textField.setText(sb.toString());//displaying result
        */

        //to sum up all count value
        int sum = 0;
        for(int c : count)
           sum+=c;
        textField.setText(sum+" times");



    }
    catch (IOException e)
    {
        e.printStackTrace();
    }

}