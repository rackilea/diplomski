.setClientId("+-2"); 
// java.lang.IllegalArgumentException: clientId must be a positive number, found: '+-2'.

.setClientId("-1"); 
// java.lang.IllegalArgumentException: clientId must be a positive number, found: '-1'.

.setClientId(null); 
// java.lang.NullPointerException