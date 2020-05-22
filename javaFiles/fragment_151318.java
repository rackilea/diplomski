while ((inputLine = in.readLine()) != null) 
{
    if (inputLine.length() > 0)
    {
        outputLine = kkp.processInput(inputLine);            
        out.println(outputLine);
        if (outputLine.equals("Bye."))
            break;
    }   
}