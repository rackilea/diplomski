@Override
public void renderHead(IHeaderResponse response)
{
    super.renderHead(response);

    response.render(OnLoadHeaderItem.forScript(
            createJavascript(newLearningCurve)));
}