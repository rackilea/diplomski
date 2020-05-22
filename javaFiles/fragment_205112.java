column {
    header "^OGC^"  /* Old Generation Capacity - Current */
    data sun.gc.generation.1.capacity
    scale K
    align right
    width 11
    format "0.0"
  }
  column {
    header "^OC^"   /* Old Space Capacity - Current */
    data sun.gc.generation.1.space.0.capacity
    scale K
    align right
    width 11
    format "0.0"
  }