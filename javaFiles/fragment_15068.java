final JFileChooser chooser = new JFileChooser();
chooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
int returnVal = chooser.showOpenDialog( this );

if( returnVal == JFileChooser.APPROVE_OPTION ) {
...

}