for(int i=0;i<SizeOfBase;i++)
{
    p4[i] = new Poly();
    p4[i].add(basePolyList.get(i));
    System.out.println("Poly of Base["+i+"]"+" has " +p4[i].getNumPoints()+"\n");
}