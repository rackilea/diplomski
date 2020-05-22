int start = findStartIndex(A, num);

if (A[start]!=num) 
{ 
     print("-1,-1"); 
}
else
{
     int end = findEndIndex(A, num);
     print(start, end);
}