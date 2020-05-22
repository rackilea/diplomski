long div2 = findDivisibles( x, y, 2 );
long div3 = findDivisibles( x, y, 3 );
long div5 = findDivisibles( x, y, 5 );
long div23 = findDivisibles( x, y, 2*3 );
long div35 = findDivisibles( x, y, 3*5 );
long div25 = findDivisibles( x, y, 2*5 );
long div235 = findDivisibles( x, y, 2*3*5 );

num = div2 + div3 + div5 - div23 - div35 - div25 + div235;