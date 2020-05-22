1 call groupSum1(0, {10, 8, 6}, 16)
    1. 0 < 3 next
2 call groupSum1(1, {10, 8, 6}, 6)
    1. 1 < 3 next
3 call groupSum1(2, {10, 8, 6}, -2)
    1. 2 < 3 next
4 call groupSum1(3, {10, 8, 6}, -8)
    1. 3 == 3 return false to call 3      
back to call 3 in line 2.
5 call groupSum1(3, {10, 8, 6}, -2)
    1. 3 == 3 return false to call 3
back to call 3 in line 3.
    return false to call 2
back to call 2 in line 2.
6 call groupSum1(2, {10, 8, 6}, 6)
    2 < 3 next
7 call groupSum1(3, {10, 8, 6}, 0)
    3 == 3 return true to call 6
back to call 6 in line 2.
    return true to call 2
back to call 2 in line 3.
    return true to call 1
back to call 1 in line 2.
    return true