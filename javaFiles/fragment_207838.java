String[][]obj = new String[first_name.length][3];

for (int i = 0; i < first_name.length; i++)
{
  obj[i][0] = first_name[i] + " " + last_name[i];
  obj[i][1] = unit[i];
  obj[i][2] = phone_number[i];
}