int getOffset(int [] sizes, int [] indices) {
  int ofs = indices[sizes.length - 1];
  for (int d = sizes.length - 2; d >= 0; --d) {
    ofs = ofs * sizes[d] + indices[d];
  }
  return ofs;
}