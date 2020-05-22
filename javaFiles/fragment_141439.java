long h, m, s; // Initialize them after calculation.
String h1, m1, s1;

h1 = Long.toString( h );
m1 = Long.toString( m );
s1 = Long.toString( s );

if ( s1.length() < 2 )
    s1 = "0" + s1;
if ( m1.length() < 2 )
    m1 = "0" + m1;
if ( h1.length() < 2 )
    h1 = "0" + h1;

String output = h1+":"+m1+":"+s1;