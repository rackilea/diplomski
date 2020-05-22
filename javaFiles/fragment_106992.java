int lastIndex = -1;//add this global to your class, not the method.

int currIndex = (int)(Math.random()*questionList.length);
do
{
   result = questionList[currIndex];
}
while (lastIndex == currIndex);