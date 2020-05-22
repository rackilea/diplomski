procedure TJBIG2Bitmap.combine(bitmap: TJBIG2Bitmap; x, y: Integer; combOp: Int64);
...
...
var
begin
  srcWidth := bitmap.width;
  srcHeight := bitmap.height;
  srcRow := 0;
  srcCol := 0;

  if (x < 0) then x := 0;
  if (y < 0) then y := 0;

  for row := y to Min(y + srcHeight - 1, Self.height - 1) do   // <<<<<<<<  HERE
  begin
    for col := x to x + srcWidth - 1 do
    begin
      srcPixel := bitmap.getPixel(srcCol, srcRow);