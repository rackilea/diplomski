class ChildB <T extends Base> extends Base {
    public ChildB(T sibling) {
      super(sibling);
    }


    @Override
    @SuppressWarnings("unchecked")
    public T getSibling() {
      return (T) super.getSibling();
    }
}