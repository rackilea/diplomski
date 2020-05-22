while (pos + findLength <= doc.getLength()) {

   found = foundPattern( doc, pos, findLength );

   if ( found ) {
      break;
   }

   pos++;

}

if ( ! found ) {
   pos = 0;

   while ( pos + findLength < component.getCaretPosition() ) {
       found = foundPattern( doc, pos, findLength );
       if ( found ) {
          break;
       }

       pos++;
   }
}