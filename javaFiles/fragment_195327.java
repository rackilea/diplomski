public void remove(T o) {
    for(int i = 0; i < _nodeArray.length; i++){
        if(_nodeArray[i].equals(o)){
            _nodeArray[i] = _nodeArray[_numNodes - 1];
            if(_nodeArray[i].compareTo(parentIdx(i)) > 0){
                bubbleUp(_nodeArray[i]);
            }
            else{
                trickleDown(_nodeArray[i]);
            }

        }
        else{
            throw new NoSuchElementException();
        }


        _numNodes--;
    }
}