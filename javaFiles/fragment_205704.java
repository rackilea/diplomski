if ( aHost instanceof Inet4Address ) {
       this.hostAddress = aHost.getHostAddress();
    }
    else if ( aHost instanceof Inet6Address ) {
       this.hostAddress = "[" + aHost.getHostAddress() + "]";
    }
    else {
       throw someException();
    }

.............some other stuff.................

    registry = LocateRegistry.getRegistry( this.hostAddress, ... );