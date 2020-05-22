private class Worker extends AsyncTask <String, Integer, Integer>
{
    private Process proc;

    @Override
    protected Integer doInBackground (String... args)
    {
        try
        {
            this.proc = Runtime.getRuntime().exec (command);
            this.proc.waitFor();
            InputStream out = this.proc.getInputStream();
            out.skip (out.available());
            InputStream err = this.proc.getErrorStream();
            err.skip (err.available());
        }
        catch (InterruptedException ex)
        {
            Log.i ("runCommand", "Interruped Exception");
            ex.printStackTrace();
            return -1;
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return -1;
        }
        return proc.exitValue();
    }

    public void abort()
    {
        if (this.proc != null) this.proc.destroy();
    }
}

Worker w = new Worker();
w.execute();
w.abort(); // Terminates the process