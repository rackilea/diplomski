if( A1 == "" && A2 == "" && A3 == "" && A4 == "")
    System.out.println("empty fields")
else if(A1.IsValid() && A2.IsValid() && B1.IsValid() && B2.IsValid()
    DoSomethingElseAB();
else if( A1.IsValid() )
{
    if(A2 == "")
        A2 = A1++;
    else if ( B1 == "" & B2 == "")
        DoSomethingElseA();

    if( A2.IsValid() && B2 == "" )
        B2 = B1++;
    else if ( B1.IsValid() && B2.IsValid() && A1 == "" && A2 == "")
        DoSomethingElseB()
}