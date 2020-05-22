// For n=1
for (int i = 0; i < 26; i++)
    System.out.println(alphabet.substring(i, i + 1));

// For n=2
for (int i = 0; i < 26; i++)
    for (int j = 0; j < 26; j++)
        System.out.println(alphabet.substring(i, i + 1) +
                           alphabet.substring(j, j + 1));

// For n=3
for (int i = 0; i < 26; i++)
    for (int j = 0; j < 26; j++)
        for (int k = 0; k < 26; k++)
            System.out.println(alphabet.substring(i, i + 1) +
                               alphabet.substring(j, j + 1) +
                               alphabet.substring(k, k + 1));