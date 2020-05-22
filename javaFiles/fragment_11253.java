...
 v6 = key[normalizeIndex(key,8 + v3)];
 key[ normalizeIndex(key,(8 + v3))] = key[ normalizeIndex(key,(8 + v5))];
 key[normalizeIndex(key,8 + key[4])] = v6;

 data[length - len - 1] ^= key[normalizeIndex(key,8+(int)(key[ normalizeIndex(key,8 + key[4])]) + key[ normalizeIndex(key,8 + key[0])])];
...