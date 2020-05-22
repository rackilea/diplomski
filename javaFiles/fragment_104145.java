//export getSearchKeys
func getSearchKeys(numKeysByReference *C.int) **C.char {
  *numKeysByReference = // ... some value
  // Using the C helper defined above
  set_char := C.cmalloc(*numKeysByReference)
  // Logic allocating and populating C.char[i .. *numKeysByReference]
  // ...
  return set_char
}