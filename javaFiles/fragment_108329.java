for (int j=0;j<no_of_family;j++)
{
    String[] familySplit = data[j].split("=");

    family[j][0] = familySplit[0];

    String[] childrenSplit = familySplit[1].split(",");
    for (int k=0;k<childrenSplit.length;k++)
    {

        family[j][k+1]= childrenSplit[k];
    }

}