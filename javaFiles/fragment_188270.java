public static void SwapNames(Sam3 obj1, Sam3 obj2)
{   
    Sam3 temp = obj2; 
    obj2 = obj1;
    obj1 = temp;

    obj1.FirstName = "First Name"; //<-- is actually objSam2 
    obj2.LastName  = "Last Name";  //<-- is actually objSam1
}