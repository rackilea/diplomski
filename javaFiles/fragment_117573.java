i = 3 iteration state
idx = -1,  0,  1, 2,  3,  4, 5, 6
arr =  0,  1,  2, 3, -1, -3, 2, 5
sum =  0   1,  2  4   ?
par =     -1, -1  0   !

// before update
currSum = 4, currPos = 2
lastSum = 2, lastPos = 1

//updating
par[3] = lastpos = 1
probableSum = max(-1 + 2, -1) = 1 // max(arr[i] + lastSum, arr[i])
? = max(4, 1) = 4 // max(currSum, probableSum) ; no update in ?'s value
! = currPos = 2 // as ?'s value didn't update

// after update
lastSum = currSum = 4
lastPos = currPos = 2
currSum = ? = 4
currPos = ! = 2