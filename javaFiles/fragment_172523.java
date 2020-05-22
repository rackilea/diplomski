int sublistIndex = 0; // choose any index  (0-based) to define which sublist
char[][] letters = {{'a','e','i','o','u','l','n','s','t','r'},{'d','g'},
       {'b','c','m','p'},{'f','h','v','w','y'},{'k'},{'j','x','q','z'}};
for(int i= 0; i < letters[sublistIndex].length; i ++)
{
   System.out.println(letters[sublistIndex][i]);
}