worker.execute(); // This starts the thread in the background

try
{
     // This immediately stops the event handler waiting for the worker to finish
    System.out.println("Return: " + worker.get().toString());
} catch (InterruptedException e1)
{
    e1.printStackTrace();
    System.out.println("Failed.");
} catch (ExecutionException e1)
{
    e1.printStackTrace();
    System.out.println("Failed.");
}