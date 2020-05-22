List data = new ArrayList<String>();
String[] data2 = null;
String[] datas = res.split("(s1)");
int i1 = 0;
int i2 = 0;
for(String datasx : datas)
{
    i1++;
    String[] datas2 = datasx.split("(s2)");

    for(String datas2x : datas2)
    {
        String[] odcinek = datas2x.split("(s3)");
        data.add(odcinek[1] + "////" + odcinek[2] + "////" + odcinek[6]);
        i2++;
    }
}