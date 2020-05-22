// 1) have a list of all fonts ArrayList allAvailableFonts;
 // 2) second list of fonts that that can be embedded ArrayList embedableFonts;

//Iterate through every available font in allAvailableFonts

for( .... allAvailableFonts ..... )
{
   boolean isFontEmbeddable = true;
   try
   {
          // try to embed the font
   }
   catch( DocumentException de)
   {
        //this font cannot be embedded
        isEmbeddable = false;
   } 

   if( isEmbeddable )
   {
       // add to list of embeddable fonts
       embedableFonts.add ( font );
   }
}