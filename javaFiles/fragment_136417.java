grunt> A = LOAD 'input.txt' USING PigStorage(',') AS (f1:int,f2:int,f3:float);
grunt> B = FOREACH A GENERATE f1+10 AS sum, f2-2 AS diff, f3/10 AS div;
grunt> DUMP B;
(11,2,1.0)
(12,3,2.0)
(13,4,3.0)