List<string> indexList = new List<string>();

for (int i = 0; i < listOfVOObj.length(); i++)
{
    for (int j = 0; j < listOfDBObj.length(); j++)
    {
        if (listOfVOObj[i].regNo == listOfDBObj[j].regNo && listOfVOObj[i].userId == listOfDBObj[j].userId)
        {
            int  index = i + 1;
            indexList.Add(index);
        }
    }
}