public class MyTextRenderListener implements RenderListener
{
    [...]

    /**
     * @see RenderListener#renderText(TextRenderInfo)
     */
    public void renderText(TextRenderInfo renderInfo) {
        out.print("<");
        out.print(renderInfo.getText());
        out.print(">");
    }
}