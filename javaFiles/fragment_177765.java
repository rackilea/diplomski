String vorname = row.getString("vorname");
char[] vornameArr = vorname.toCharArray();          
for (int i = 0; i < vornameArr.length; i++)
{
    if (vornameArr[i] > 255)
    {
        vornameArr[i] = (char) (String.valueOf(vornameArr[i]).getBytes("cp1252")[0] & 0xff);
    }

    vornameArr[i] = (char) (vornameArr[i] ^ DECRYPT_KEY[i]);
}

System.out.println(String.valueOf(vornameArr));