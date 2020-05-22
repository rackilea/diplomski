for (int k = 0; k < m; k++)
{
    while (true) {
       int a = r.nextInt(w);
       int b = r.nextInt(h);
       if (mineField[a][b] != State.MINED) { // We have discovered an un-mined location.
           mineField[a][b] = State.MINED;
           break; // get out of the while loop.
       }
    }
}