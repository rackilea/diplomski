String[] arraysplit;
arraysplit = str_array.split(":");

for (int i=0; i<arraysplit.length; i++)
{
    arraysplit[i] = arraysplit[i].trim();
    //              ^^^^^^^^^^^^ has values with spaces
    System.out.println(arr[i]);
}

System.out.println(arraysplit[i]);