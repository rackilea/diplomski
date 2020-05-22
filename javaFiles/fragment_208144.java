Begin {Algorithm LC} 
{ s is the current state}
{ L is the size of a line (row or column) in the puzzle. L = sqrt( N + 1 )
{ C(tj, ri) is the number of tiles in row ri with which tj is in conflict} 
{ C(tj, ci) similarly}
{ lc(s, rj) is the number of tiles that must be removed from row rj to resolve the linear conflicts}
{ lc(s, cj) similarly}
{ md(s, ti) is the Manhattan Distance of tile ti} 
{ MD(s) is the sum of the Manhattan Distances of all the tiles in s} 
{ LC(s) is the minimum number of additional moves needed to resolve the linear conflicts in s} 
For each row ri in the state s 
   lc(s, ri) = 0
   For each tile tj in ri 
      determine C(tj, ri) 
   While there is a non-zero C(tj, ri) value 
       Find tk such that there is no 
          C(tj, ri) > C(tk, ri) { As tk is the tile with the most conflicts, we choose to move it out of ri }
       C(tk, ri) = 0 
       For every tile tj which had been in conflict with tk 
          C(tj, ri) = C(tj, ri) - 1 
       lc(s, ri) = lc(s, ri) + 1 
{ Check similarly for linear conflicts in each column ci, computing lc(s, cj ). }
LC(s) = 2[lc(s, r1) + . .. + lc(s, rL) + lc(s,ci) + . . . + lc(s, cL)] 
For each tile tj in s 
    determine md(s, tj) 
MD(s) = ms(s, t1) + ... + md(s, tn)
h(s) = MD(s) + LC(s)