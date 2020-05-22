public static void listPaths(BinaryNodeInterface<Character> node , StringBuilder builder , String path){
     builder.append('\n');
     builder.append(node.getData());
     builder.append(" " + path);

     if(node.getLeftChild() != null)
          listPaths(node.getLeftChild() , builder , path + "0");

     if(node.getRightChild() != null)
          listPaths(node.getRightChild() , builder , path + "1");
}

public String listPaths(BinaryNodeInterface<Character> node){
     StringBuilder builder = new StringBuilder();
     listPaths(node , builder , "");
     builder.deleteChar(0);//delete first char (useless '\n')
     return builder.toString();
}