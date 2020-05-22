public NodeProperty pTwoWay;
    public NodeProperty pBinary;

    // more properties

    public NodeConfig() {
        // 
    }

    public NodeProperty getProperty(NodePropertyEnum nodeProp) {
        switch(nodeProp) {
            case TWO_WAY: 
                if (pTwoWay != null) {return pTwoWay;}
                pTwoWay = new NodeProperty( "Two way", Status.OPTIONAL, Visibility.VISIBLE ); 
            case BINARY_MODE: 
                if (pBinary != null) {return pBinary;}
                pBinary = new NodeProperty( "Binary mode", Status.OPTIONAL, Visibility.VISIBLE); 
            // other cases
            default: 
                throw new IllegalArgumentException();
        }
    }
}