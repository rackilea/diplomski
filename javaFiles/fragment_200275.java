int nums[] = { 1, 9, 9, 0 };

StringBuilder strNum = new StringBuilder();

for (int num : nums) 
{
     strNum.append(num);
}
int finalInt = Integer.parseInt(strNum.toString());
System.out.println(finalInt);