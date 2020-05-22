String arrayIdent[] = { "abanico", "camboya", "retrato", "ovalado" };
String arrayDatos[] = { "camboya", "retrato", "ovalado", "granizo", "riachuelo" };

boolean found;    
for (int k = 0; k < arrayIdent.length; k++)
{
   found = false;
   for (int j = 0; j < arrayDatos.length; j++)
      if(arrayIdent[k].equals(arrayDatos[j]))
      {
         System.out.println(arrayIdent[k] + " is equal to " + arrayDatos[j]);
         found = true;
      }
   if (!found)
      System.out.println(arrayIdent[k] + " is not equal to any element");
}