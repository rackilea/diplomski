function interchange(position1,position2,newposition1,newposition2) {
    // store the value at (position1,position2)
    var temp = Array[position1][position2]

    // put in (position1,position2) the value at (newposition1,newposition2)
    Array[position1][position2] = Array[newposition1][newposition2]

    // put in (newposition1,newposition2) the value previously stored
    Array[newposition1][newposition2] = temp
}