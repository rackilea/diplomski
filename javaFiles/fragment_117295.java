import mpi.* ;

class Hello {

    static public void main(String[] args) {

        MPI.Init(args);
        int myrank = MPI.COMM_WORLD.Rank();
        int tag = 99;
        int maxlen = 512*1024*1024;
        int minlen = 64;
        char [] sendbuff = new char [maxlen];
        char [] recvbuff = new char [maxlen];


        if (myrank == 0) {
            for (int len = minlen; len < maxlen; len *= 4) {
                long startTime = System.currentTimeMillis();                    
                 MPI.COMM_WORLD.Send(sendbuff, 0, len, MPI.CHAR, 1, tag);
                 MPI.COMM_WORLD.Recv(recvbuff, 0, len, MPI.CHAR, 1, tag);
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                System.out.println("Ping-pong time for " + len + " is " + duration);
            }
        } else if (myrank == 1) {
            for (int len = minlen; len < maxlen; len *= 4) {
                 MPI.COMM_WORLD.Recv(recvbuff, 0, len, MPI.CHAR, 0, tag);
                 MPI.COMM_WORLD.Send(recvbuff, 0, len, MPI.CHAR, 0, tag);
            }
        }


        MPI.Finalize();
    }
}