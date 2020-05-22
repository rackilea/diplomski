int result = 0;

if(marks != null)
{
    Collections.sort(marks);
    for(int i=0;i<marks.size();i++)
    {
        if(marks.get(i) > 40)
        {
            result = marks.size() - i;
            break;
        }
    }
}