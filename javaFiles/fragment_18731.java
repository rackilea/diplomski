funTakingOne { 
  it + 2 
}
funTakingOne { 
  return@funTakingOne it + 2
}