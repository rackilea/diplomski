List<JButton> digits = new ArrayList<>();
for( int i = 0; i < 10; i++ ){
    JButton b = new JButton( "" + i );
    digits.add( b );
    num.add( b );
}

// in actionPerformed
int dig = digits.indexOf( e );
if( dig >= 0 ){
    txt.append( dig );
}