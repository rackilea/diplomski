if (array[randomIndexA] > array[randomIndexB]) {
  if (array[randomIndexB] > array[randomIndexC]) {
    return "b is the middle value";
  } else if (array[randomIndexA] > array[randomIndexC]) {
    return "c is the middle value";
  } else {
    return "a is the middle value";
  }
} else {
  if (array[randomIndexA] > array[randomIndexC]) {
    return "a is the middle value";
  } else if (array[randomIndexB] > array[randomIndexC]) {
    return "c is the middle value";
  } else {
    return "b is the middle value";
  }
}