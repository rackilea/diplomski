while(pos == -1 && index < network.size()){
    if(network.get(index).getName().equals(current)) {
        pos = index;
    }
    index++;
}