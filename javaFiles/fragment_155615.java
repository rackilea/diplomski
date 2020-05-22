public void generateFingerTable (int node_position) {

        chordSize = chord.initChordSize;        
        chord chord = new chord();  

        //create new node and add to map
        node newPeer = new node();
        peerList.put(node_position, newPeer);

        newPeer.index = new int [chordSize];
        newPeer.successor = new int [chordSize];
        for (int i=0; i<chordSize; i++) {
            int temp = i+1; 
            int temp1 = node_position + (int)Math.pow(2, temp-1) % chord.getChordSize();
            peerList.get(node_position).index[i] = temp;                
            peerList.get(node_position).successor[i] = temp1;

            System.out.println ("Index: "  + newPeer.index[i] + "\n" + "Successor: " + 
                    newPeer.successor[i]);          
        }
}