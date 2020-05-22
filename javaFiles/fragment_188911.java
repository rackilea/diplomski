/** Whether the delta chain length is long enough that it should be compacted */
  def shouldCompact: Boolean = {
    deltaChainLength >= deltaChainThreshold
  }
  // Write the data in the parent state map while copying the data into a new parent map for
    // compaction (if needed)
    val doCompaction = shouldCompact
...