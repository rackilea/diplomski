static void permute(char[] arr, int pos, int distance, char[] candidates)
{
   if (pos == arr.length)
   {
      System.out.println(new String(arr));
      return;
   }
   // distance > 0 means we can change the current character,
   //   so go through the candidates
   if (distance > 0)
   {
      char temp = arr[pos];
      for (int i = 0; i < candidates.length; i++)
      {
         arr[pos] = candidates[i];
         int distanceOffset = 0;
         // different character, thus decrement distance
         if (temp != arr[pos])
            distanceOffset = -1;
         permute(arr, pos+1, distance + distanceOffset, candidates);
      }
      arr[pos] = temp;
   }
   // otherwise just stick to the same character
   else
      permute(arr, pos+1, distance, candidates);
}