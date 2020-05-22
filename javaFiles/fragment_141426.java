for pass = 1 to n {
  //at each pass, find the minimal item in the list (that we haven't already sorted)
  indexMin = pass
  for item = pass + 1 to n {
    if data[item] < data[indexMin] {
      indexMin = item
    }
  }
  swap data[pass] and data[indexMin]
}