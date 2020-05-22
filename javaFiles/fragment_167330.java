private String[] arrayListToString()
{
    NepGarazasCtr garCtr = new NepGarazasCtr();
    List<NepGarazas> gautGar = garCtr.gautVisusGarazus();

    String[] stringArray = new String[gautGar.size()];

    for(int i = 0; i < gautGar.size(); i++)
    {
        NepGarazas npGar = gautGar.get(i);
        stringArray[i] = npGar.getGarazoPav();
        System.out.println(nepGar);
    }
    return stringArray;
}