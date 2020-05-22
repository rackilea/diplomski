batch.getTransformMatrix().idt().translate(0, 0, z);
batch.begin();
... do your rendering here
batch.end();
// reset the matrix, so you can use the batch for other stuff
batch.idt();