private String[] arrayListToString()
{
    NepGarazasCtr garCtr = new NepGarazasCtr();
    List<NepGarazas> gautGar = garCtr.gautVisusGarazus();

    List<String> stringList = new ArrayList<String>();

    for(NepGarazas npGar: gautGar)
    {
        stringList.add(npGar.getGarazoPav());
        System.out.println(nepGar);
        //System.out.println(Arrays.toString(nepGar));
    }
    return stringList.toArray(new String[stringList.size()]);
}


...


String[] array =  arrayListToString();