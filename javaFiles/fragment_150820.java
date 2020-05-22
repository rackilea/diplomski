@Root(name = "div")
@Convert(value = Div.DivConverter.class) // Set the Converter for this class
public class Div
{
    private Set< String> _classes = new HashSet< String>()
    {
        {
            add("a");
            add("b");
            add("c");
        }
    };

    // some methods and attributes...

    public Set<String> getClasses()
    {
        return _classes;
    }

    // ...


    /*
     * Converter implementation.
     */
    static class DivConverter implements Converter<Div>
    {
        @Override
        public Div read(InputNode node) throws Exception
        {
            /*
             * Not required for writing, therefore not implemented int this
             * example.
             */
            throw new UnsupportedOperationException("Not supported yet.");
        }



        @Override
        public void write(OutputNode node, Div value) throws Exception
        {
            StringBuilder sb = new StringBuilder(); // Used to store the set's values in string-form
            Set<String> cl = value.getClasses();

            if( cl.isEmpty() == false ) // Check if classes is empty - nothing to do if so
            {
                int pos = 0;    // Keep trac of current position (not to add an blank char for last entry)
                final int size = cl.size();

                for( String s : cl )    // Iterate over all entries of classes
                {
                    sb.append(s);   // Append the entry to buffer

                    if( (pos++) < size - 1 )
                    {
                        sb.append(' '); // If not last entry, add a blank
                    }
                }
            }

            // Finally add the attribute 'class' with the content, to the 'div'-node
            node.setAttribute("class", sb.toString());
        }
    }
}