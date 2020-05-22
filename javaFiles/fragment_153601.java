//Button Remove
public class ActionRemove implements ActionListener
{

    public void actionPerformed(ActionEvent evt)
    {
        List<Statement> statementsToRemove = new ArrayList<Statement>();

        // step 1
        StmtIterator iter = onto.model.listStatements();
        while (iter.hasNext()) 
        {
            Statement stmt  = iter.nextStatement(); 

            Resource  subject = stmt.getSubject(); 
            Property  predicate = stmt.getPredicate();  
            RDFNode object  = stmt.getObject();  
            if(subject.toString().equals (onto.uriBase+"#"+tabTF[0].getText()))
            {
                statementsToRemove.add(stmt);
            }
       }

       // step 2
       for( Statement stmt : statementsToRemove) 
       {
            onto.model.remove(stmt);
       }
   }
}