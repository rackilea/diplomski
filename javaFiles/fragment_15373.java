for(int i=0;i<2;i++)
{
    obj[i] = new Chef();
    System.out.println("for the object "+i+" enter the name ");
    obj[i].name=input.next();
    System.out.println("for the object "+i+" enter the city ");
    obj[i].city=input.next();
    System.out.println("for the object "+i+" enter the value ");
    obj[i].value=input.nextInt();
}