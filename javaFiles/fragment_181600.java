public int compareTo(person a, person b) {
    if (a.y == b.y)
       return a.x-b.x
    else
       return b.y-a.y
}

//compareTo(Tom, Harry) == -50 (tom is before harry)
//compareTo(Tom, Bob) == -25 (tom is before bob)
//compareTo(Dave, Bob) == 30 (dave is after bob)