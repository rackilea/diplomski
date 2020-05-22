PngReader pngr = new PngReader(origFile);
PngWriter pngw = new PngWriter(destFile, pngr.imgInfo, true);
// instruct the writer to copy all ancillary chunks from source
pngw.copyChunksFrom(pngr.getChunksList(), ChunkCopyBehaviour.COPY_ALL);
// add a new textual chunk (can also be done after writing the rows)
pngw.getMetadata().setText("my key", "my val");
// copy all rows
for (int row = 0; row < pngr.imgInfo.rows; row++) {
  IImageLine l1 = pngr.readRow();
  pngw.writeRow(l1);
}
pngr.end(); 
pngw.end();