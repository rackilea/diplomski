private Result doDecode(MonochromeBitmapSource image, Hashtable hints) throws ReaderException {


int width = image.getWidth();
int height = image.getHeight();
BitArray row = new BitArray(width);
boolean tryHarder = hints != null && hints.containsKey(DecodeHintType.TRY_HARDER);
RowNumberStrategy rowProvider = new RowNumberStrategy.ProgressiveScanRowStrategy(height);  

int rowNumber;
while ((rowNumber = rowProvider.getNextRowNumber()) != -1){
...
}