for (int j = 0; j < n2; j++) {  
       int i = 0;
       while (i < n1 && s2[j] == s1[i])
         i++;
       if (i == n1)
         s3[n3++] = s2[j];
}