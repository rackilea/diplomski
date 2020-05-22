class CommentOutModifier extends AbstractBehavior {
    private static final long serialVersionUID = 1L;

    @Override
    public void beforeRender(Component component) {
        component.getResponse().write("<!--");
    }

    @Override
    public void onRendered(Component component) {
      component.getResponse().write("-->");
    }
}

add(new Label("tohide", "Hi, can you see me?").add(new CommentOutModifier()));