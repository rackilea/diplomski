class Monitor<T extends Monitor<T>>
{
    WebScoutCallable<T> handler;

    public void setCallable(WebScoutCallable<T> callable) {
         this.handler = callable;
    }
}