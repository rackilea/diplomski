List<MyClass> indexList = new List<MyClass>();

for (int i = 0; i < listOfVOObj.length(); i++)
{
   for (int j = 0; j < listOfDBObj.length(); j++)
   {
       if (listOfVOObj[i].regNo == listOfDBObj[j].regNo && listOfVOObj[i].userId == listOfDBObj[j].userId)
       {
           int  index1 = i + 1;
           int  index2 = j + 1;
           indexList.Add(new MyClass(index1, index2));
       }
   }
}