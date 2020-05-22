int stock[] = new int[40];
 char letter = 'A';

 // After j loop exists, here i again gets incremented.
 for (int i = 0; i < stock.length; ++i) {
    for (int j = 1; j < 7; j++) {
        System.out.println(i + " " + letter + j);
        i++; // This increments the value of i
    }
    letter++;
 }

0 A1
1 A2
2 A3
3 A4
4 A5
5 A6
7 B1
8 B2
9 B3
10 B4
11 B5
12 B6
14 C1
15 C2
16 C3
17 C4
18 C5
19 C6
21 D1
22 D2
23 D3
24 D4
25 D5
26 D6
28 E1
29 E2
30 E3
31 E4
32 E5
33 E6
35 F1
36 F2
37 F3
38 F4
39 F5
40 F6