public void ParentFunction()
{
    List<String> results = new ArrayList<String>();
    Permute(..., ..., results);
    // Now you have all results inside "results" variable.
}

public static void Permute(String soFar, String rest, List<String> results)  
{
    if (rest.isEmpty())  
    {
        //System.out.println(soFar);  
        results.add(soFar); // ADD TO RESULT LIST
    }           
    else  
    {  
        for (int i = 0; i < rest.length(); i++)  
        {  
            String next = soFar + rest.charAt(i);  
            String remaining  = rest.substring(0, i) + rest.substring(i + 1);  
            Permute(next, remaining, results);  
        }  
    }
}