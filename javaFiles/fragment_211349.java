per          literal, would match "per" -- it's always so
             -- let's try to imagine how the rest could match:
sonn         would match \p{Alpha}{1,100}
e            wouldn't match [sx], FAIL
             -- or maybe
s            would match \p{Alpha}{1,100}
o            wouldn't match [sx], FAIL
             -- or maybe yet
so           would match \p{Alpha}{1,100}
n            wouldn't match [sx], FAIL.