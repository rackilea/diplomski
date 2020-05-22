If(yyyy <= 1752)
{
    If(yyyy==1752)
    {
        If(mm<=09)
        {
            If(mm==09)
            {
                If(dd >3 && dd<13)
                     Print("Date never occurred.");
                Else if(dd<3)
                    Equation1(date);
                Else 
                    Equation2(date);
            }
            Else
                Equation1(date);
        }
        else
        {
            Equation2(date);
        }
    }
    else
        Equation1(date);
}
Else
{
  Equation2(date);
}