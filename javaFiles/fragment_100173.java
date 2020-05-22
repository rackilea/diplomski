if (graphics instanceof PrinterGraphics)
{
    PrinterGraphics pg = (PrinterGraphics) graphics;
    pg.getPrinterJob().cancel();
}
else
{
    // this is kind of an unexpected circumstance
    // not sure if we should do this or throw IllegalStateException()
    PrinterAbortException pae = new PrinterAbortException();
    pae.initCause(/* something */);
    throw pae;
}