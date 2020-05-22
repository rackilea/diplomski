public interface Comment<T extends Comment<T>> {

    // Note: no public modifier; it's allowed by the spec but discouraged
    void setCommentList(List<T> comments);
    List<T> getCommentList();
}