1

5 -> 4 -> (-1, 9)

3 -> 2 -> (-1, 5)

2 -> 3 -> (-1, 5)

3 -> (-3, 5)

tree for k = 2 so far:

   3 (-1, 5)
  /         \
2 (-1, 5)   5 (-1, 9)

1 is less than 3 so we first add -1
to the max for the right subtree
stored for f(j, k - 1) + Aj

-1 + 9 = 8
(note that this represents {1,5,1})

then we continue left in the tree
and compare 8 to a similar calculation
with node 2: -1 + 5 = 4
(note that this represents {5,2,1})