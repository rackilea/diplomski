stack = []
stack.push(rootElement)
results = []

while(stack is not empty) {
  elt = stack.pop()
  if (elt.is_leaf()) {
    results.push(elt)
  }
  else { // not a leaf: add children to the stack
    for (c in elt.children()) {
      stack.push(c)
    }
  }
}