String phrase = "12345.67" ;
Float num = new Float( phrase ) ;
int dollars = (int)Math.floor( num ) ;
int cent = (int)Math.floor( ( num - dollars ) * 100.0f ) ;

String s = "$ " + EnglishNumberToWords.convert( dollars ) + " and "
           + EnglishNumberToWords.convert( cent ) + " cents" ;