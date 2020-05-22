String vowels = "aeiou";
int i = 0;
while ((i < word.length) && (!vowels.contains(word.subSequence(i, i + 1))))
  ++i;
// now word[i] is the first non-vowel character in word
if (i == word.length) // word was all consonants
{ ...
}
else
  if (i) // word has a consonant prefix
  { ...
  }
  else // word starts with a vowel
  { ...
  }