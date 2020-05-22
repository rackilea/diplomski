[088a234e-17d0-4f3a-bb7c-ec6e4a464fa2] [ratpack-compute-786-2] no pending execution and downstream is not null and cached is null...
[088a234e-17d0-4f3a-bb7c-ec6e4a464fa2] [ratpack-compute-786-2] calling yield...  
[088a234e-17d0-4f3a-bb7c-ec6e4a464fa2] [ratpack-compute-786-2] upstream.connect.success
[088a234e-17d0-4f3a-bb7c-ec6e4a464fa2] [ratpack-compute-786-2] releasing upstream... (ExecResult{complete=false, error=null, value=12}) 
[088a234e-17d0-4f3a-bb7c-ec6e4a464fa2] [ratpack-compute-786-3] no pending execution and downstream is not null and cached is null...
[088a234e-17d0-4f3a-bb7c-ec6e4a464fa2] [ratpack-compute-786-3] calling yield... upstream is null... 
[4f00c50a-4706-4d22-b905-096934b7c374] [ratpack-compute-786-4] no pending execution and downstream is not null and cached is null...
[4f00c50a-4706-4d22-b905-096934b7c374] [ratpack-compute-786-4] calling yield...  
[4f00c50a-4706-4d22-b905-096934b7c374] [ratpack-compute-786-4] upstream.connect.success
[4f00c50a-4706-4d22-b905-096934b7c374] [ratpack-compute-786-4] releasing upstream... (ExecResult{complete=false, error=null, value=12}) 
[4f00c50a-4706-4d22-b905-096934b7c374] [ratpack-compute-786-4] upstream does not need fetching...
[8b27d16f-dc91-4341-b630-cf5c959c45e8] [ratpack-compute-786-6] no pending execution and downstream is not null and cached is null...
[8b27d16f-dc91-4341-b630-cf5c959c45e8] [ratpack-compute-786-6] calling yield...  
[8b27d16f-dc91-4341-b630-cf5c959c45e8] [ratpack-compute-786-6] upstream.connect.success
[8b27d16f-dc91-4341-b630-cf5c959c45e8] [ratpack-compute-786-6] releasing upstream... (ExecResult{complete=false, error=null, value=12}) 
[8b27d16f-dc91-4341-b630-cf5c959c45e8] [ratpack-compute-786-6] upstream does not need fetching...
[088a234e-17d0-4f3a-bb7c-ec6e4a464fa2] [ratpack-compute-786-3] calling receiveResult after catching exception class java.lang.NullPointerException
[088a234e-17d0-4f3a-bb7c-ec6e4a464fa2] [ratpack-compute-786-3] releasing upstream... (ExecResult{complete=false, error=java.lang.NullPointerException, value=null}) 

java.lang.NullPointerException
    at app.AnotherPromiseTest$TestCachingUpstream.yield(AnotherPromiseTest.java:120)
    at app.AnotherPromiseTest$TestCachingUpstream.tryDrain(AnotherPromiseTest.java:89)
    at app.AnotherPromiseTest$TestCachingUpstream.lambda$connect$0(AnotherPromiseTest.java:146)
    at ratpack.exec.internal.DefaultExecution.lambda$null$2(DefaultExecution.java:122)
    at ratpack.exec.internal.DefaultExecution$SingleEventExecStream.exec(DefaultExecution.java:489)
    at ratpack.exec.internal.DefaultExecution.exec(DefaultExecution.java:216)
    at ratpack.exec.internal.DefaultExecution.exec(DefaultExecution.java:209)
    at ratpack.exec.internal.DefaultExecution.drain(DefaultExecution.java:179)
    at ratpack.exec.internal.DefaultExecution.<init>(DefaultExecution.java:92)
    at ratpack.exec.internal.DefaultExecController$1.lambda$start$0(DefaultExecController.java:195)
    at io.netty.util.concurrent.PromiseTask.run(PromiseTask.java:73)
    at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:163)
    at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:404)
    at io.netty.channel.epoll.EpollEventLoop.run(EpollEventLoop.java:309)
    at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:886)
    at ratpack.exec.internal.DefaultExecController$ExecControllerBindingThreadFactory.lambda$newThread$0(DefaultExecController.java:136)
    at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
    at java.lang.Thread.run(Thread.java:748)