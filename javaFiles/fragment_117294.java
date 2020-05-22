import mpi.* ;

class Hello {

    static public void main(String[] args) {

        MPI.Init(args);
        int myrank = MPI.COMM_WORLD.Rank();
        int tag = 99;

        long startTime = System.currentTimeMillis();
        if (myrank == 0) {
            char[] mess = new char [1024];
            MPI.COMM_WORLD.Send(mess, 0, mess.length, MPI.CHAR, 1, tag);
        } else if (myrank == 1) {
            char[] mess = new char[1024];
            MPI.COMM_WORLD.Recv(mess, 0, 1024, MPI.CHAR, 0, tag);
            System.out.println("received:" + new String(mess));
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(duration);
        MPI.Finalize();
    }
}