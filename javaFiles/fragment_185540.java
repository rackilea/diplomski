/**
  * write according to this visitor
  */
    public void write(Type type, NodeMap<OutputNode> node) {
        OutputNode element = node.getNode();
        Class ctype = type.getType();

        String comment = ctype.getName();
        if (!element.isRoot()) {
            Comment commentAnnotation = type.getAnnotation(Comment.class);
            if (commentAnnotation!=null)
                element.setComment(commentAnnotation.value());
            else
                element.setComment(comment);
        }
    }

    @Override
    public void read(Type type, NodeMap<InputNode> nodeMap) throws Exception {

    }

}