AttributedCharacterIterator runaci = textRun.getACI();
char c = runaci.first();
TextPaintInfo tpi = (TextPaintInfo) runaci.getAttribute(PAINT_INFO);
if ( tpi == null || !tpi.visible )
   {
      return y;
    }
g2d.setPaint(tpi.fillPaint);