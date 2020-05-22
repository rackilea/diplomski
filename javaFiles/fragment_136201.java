String values = null;
int NoOfValuesPrinted = 0;
while (rs.next()) 
{
    values = rs.getString(1);
    String[] valueTokens = values.split("\\s");
    for(int i=0;i<valueTokens.length;i++)
    {
        System.out.print(valueTokens[i]);
        NoOfValuesPrinted++;
        if(NoOfValuesPrinted % 6 == 0)
        {
            System.out.println();
            NoOfValuesPrinted = 0;
        }
        else
            System.out.print(",");
    }
}