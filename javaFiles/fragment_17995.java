Can you send `kill -SIGINT <pid>` to the process (given that you know the process ID):

    Runtime.getRuntime().exec("kill -SIGINT 12345");

Of course, that would make for a platform-dependent solution... Potentially, you'll be able to use this tool, although it is in "sandbox mode". But it might give you an idea:

http://commons.apache.org/sandbox/runtime/

See also this related question here:

https://stackoverflow.com/questions/2950338/how-can-i-kill-a-linux-process-in-java-with-sigkill-process-destroy-does-sigte