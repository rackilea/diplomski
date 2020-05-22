String consgroups[] = word[i].split("[aeiou]"); // split on all vowels
int maxlen = consgroups[0].length, maxidx = 0;
for (int j = ; j < consgroups.length; ++j)    // iterate over groups and find max
  if (consgroups[j].length > maxlen)
  { maxidx = j;
    maxlen = consgroups[i].length;
  }