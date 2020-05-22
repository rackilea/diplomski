public class OperationBuilder
  {

    public Bridge<A> OperationBuilder notify(A a, CompletionHandler<Integer, A> h)
    {
       return new Bridge<A>(a, h);
    }

    protected abstract<A> void build(Bridge<A> b);



    public class Bridge<A>
    {
        private A attachment;
        private CompletionHandler<Integer, A> handler;

        public Bridge(A a, CompletionHandler<Integer, A> h)
        {
           attachment = a;
           handler = h;
        }


        public void build()
        {
           build(this); // Will invoke OperationBuilder.build()
        }               
    }
  }