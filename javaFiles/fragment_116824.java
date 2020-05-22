int sizeOfTree(File root){
    // Start the counter at 1 because the root node counts

    int size = 1;

    LinkedList<File> stack = new LinkedList<File>();
    stack.add(root);

    while(!stack.isEmpty()){
        File f = stack.remove();
        for(File child : f.listFiles()){
            size++;
            stack.add(child);
        }
    }

    return size;
}