while(huffmanList.size() > 1){
    HuffmanNode x = huffmanList.poll();
    HuffmanNode y = huffmanList.poll();
    HuffmanNode result = new HuffmanNode("-", x.getCount() + y.getCount(), null, x, y);
    huffmanList.add(result);                    
}
root = huffmanList.poll();