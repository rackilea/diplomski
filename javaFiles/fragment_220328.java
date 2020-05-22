private void searchFrames(List<Integer> route)
{
    doWhateverYouWannaDoHere();
    if (route.size() < MAX_DEPTH)
    {
        int numOfFrames = webDriver.findElements(By.tagName("iframe")).size();
        for (int i=0; i<numOfFrames; i++)
        {
            try
            {
                webDriver.switchTo().frame(i);
                List<Integer> newRoute = new ArrayList<Integer>(route);
                newRoute.add(i);
                searchFrames(newRoute);
                webDriver.switchTo().defaultContent();
                for (int j : route)
                    webDriver.switchTo().frame(j);
            }
            catch (NoSuchFrameException error)
            {
                break;
            }
            catch (Exception error)
            {
            }
        }
    }
}