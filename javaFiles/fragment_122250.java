class Post {
    ...
    @ManyToOne(fetchType = FetchType.LAZY)
    @JoinFormula("(SELECT D.ID FROM POST_DETAIL D WHERE D.REF_ID = ID AND D.LANG = 'EN')")
    private PostDetail postDetailEn;
}