@Benchmark
  public boolean getClassic(BitSetState state) {
      return state.bitSet.get(state.nextIndex);
  }

  @Benchmark
  public boolean getOpen(BitSetState state) {
      return state.openBitSet.get(state.nextIndex);
  }

  @Benchmark
  public boolean getOpenFast(BitSetState state) {
      return state.openBitSet.fastGet(state.nextIndex);
  }