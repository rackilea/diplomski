Product p = getElementOrNull( productList, 0 );
if( p == null ) { return null; }

Customer c = getElementOrNull( p.getCustomerList(), 0 );
if( c == null ) { return null; }

Address a = getElementOrNull( c.getAddressList(), 0 );
if( a == null ) { return null; }   

Region r = a.getRegion();
if( r == null ) { return null; }   

return r.getCode();