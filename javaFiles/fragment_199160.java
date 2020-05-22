private static void scrollContextMenuUp(ContextMenu contextMenu) {
    try {
        ContextMenuSkin skin = (ContextMenuSkin) contextMenu.getSkin();
        ContextMenuContent content = (ContextMenuContent) skin.getNode();
        Method method = content.getClass().getDeclaredMethod("scroll", double.class);
        method.setAccessible(true);
        method.invoke(content, 12.0); // change this double value to scroll more
    } catch (Exception e) {
        System.err.println("Unable to scroll due to: " + e.getMessage());
    }
}