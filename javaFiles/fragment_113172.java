Iterator<Runnable> runIt = listeners.iterator();
while (runIt.hasNext())
{
    Runnable listener = runIt.next();
    Platform.runLater(listener);
    runIt.remove();
}