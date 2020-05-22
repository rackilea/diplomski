String olle = "อภิชาติ";
int count = 0;

for(int i=0; i<olle.length(); i++)
{
    if(!isMark(olle.charAt(i)))
        count++;
}

System.out.println(count);