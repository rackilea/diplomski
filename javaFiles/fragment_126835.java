package test;

import javafx.concurrent.Task;


public class TestTask extends Task<String>
{
    @Override
    protected String call() throws Exception
    {
        StringBuilder builder = new StringBuilder();
        int max = 1000;

        for (int i = 0; i < max; i++)
        {
            if (isCancelled())
            {
                throw new InterruptedException();
            }

            builder.append(i);
            updateProgress(i, max - 1);
        }

        return builder.toString();
    }
}