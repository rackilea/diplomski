/**
     * write according to this visitor
     */
    public void write(Type type, NodeMap<OutputNode> node) {
        OutputNode element = node.getNode();
        Class ctype = type.getType();

        String comment = ctype.getName();
        if (!element.isRoot()) {
            FieldHelper fh = new FieldHelper();
            element.setComment(comment);
            try {
                if (type.getClass().getSimpleName().startsWith("Override")) {
                    type = (Type) fh.getFieldValue(type, "type");
                }
                if (type.getClass().getSimpleName().startsWith("Field")) {
                    Field field = (Field) fh.getFieldValue(type, "field");
                    System.out.println(field.getName());
                    Comment commentAnnotation = field.getAnnotation(Comment.class);
                    if (commentAnnotation != null) {
                        element.setComment(commentAnnotation.value());
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }