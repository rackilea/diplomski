for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
    if (child.getNodeType() == Node.COMMENT_NODE) {
        Comment comment = (Comment) child;
        System.out.println("COMMENTS : " + comment.getData());
    }
}