Sort warehouses by starting time so that s1 ≤ s2 ≤ ... ≤ sn.
d ← 0
for j = 1 to n {
 if (warehouse j is compatible with some agent k)
 schedule warehouse j to agent k
 else
 allocate a new agent d + 1
 schedule warehouse j to agent d + 1
 d ← d + 1
}