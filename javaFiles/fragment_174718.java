input.txt  
This is Apache pig,  
works like  
a charm  

PigScript:  
A = LOAD 'input.txt' AS line;  
B = FOREACH A GENERATE (REPLACE(line,'','\n')) AS (word:chararray);  
C = FOREACH B GENERATE FLATTEN(TOKENIZE(word,'\n'));  
D = GROUP C BY $0;  
E = FOREACH D GENERATE group,COUNT($1);  
DUMP E;  

Output:  
( ,6)  
(,,1)  
(A,1)  
(T,1)  
(a,3)
(c,2)
(e,2)
(g,1)
(h,3)
(i,4)
(k,2)
(l,1)
(m,1)
(o,1)
(p,2)
(r,2)
(s,3)
(w,1)