public class myProcess extends Thread

...

for(int i = 0; i < N; i++){
    t[i] = new myProcess(i);
    t[i].start();
}