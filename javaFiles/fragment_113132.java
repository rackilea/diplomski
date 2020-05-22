int first, second;

first = second = Integer.MIN_VALUE;

String firstWord, secondWord;

for (Map.Entry<String, Integer> entry : map.entrySet())
{

   int count = entry.getValue();
   String word = entry.getKey();

    if (count > first)
    {
       second = first;
       secondWord = firstWord;
       first = count;
       firstWord = word;
    }
    else if (count > second && count != first)
    {
      second = count;
      secondWord = word;
    }
}

System.out.println(firstWord + " " + first);
System.out.println(secondWord + " " + second);