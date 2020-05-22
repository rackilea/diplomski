public class MyCompletionService implements Executor /* optional implements CompletionService too */ {
      private final Executor mExecutor;
      private Queue<Runnable> mRunnableQueue;

      public MyNotifyingExecutorWrapper (Queue<Runnable> queueToNotify, Executor wrapped) {
             mExecutor = wrapped;
             mRunnableQueue = queueToNotify;
      }


      public execute(Runnable command) {
             mExecutor.execute(new NotifyingRunnable(command, mRunnableQueue));
      }

      private static class NotifyingRunnable implements Runnable {
            private final Queue<Runnable> mRunnables;
            private Runnable mRunnable;

            public NotifyingRunnable(Runnable runnable, Queue<Runnable> done) {
                 mRunnables = done;
                 mRunnable = runnable;
            }
            public void run() {
                  mRunnable.run();
                  mRunnables.add(mRunnable);
            }
      }
  }