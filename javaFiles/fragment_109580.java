boolean found = false;
for ( Shape s : images ) {
  if ( click is in s ) {
     s.setSelected(true);
     found = true;
     break;
   }
} 
if ( !found ) {
   // set all images to unselected here
}
repaint();