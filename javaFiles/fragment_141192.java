public static void main(String[] arg)
{
      boolean b[]=new boolean[9];
      int test=0x01f;

      b[1] = (test & 1) !=0;//(test & 1) !=0;
      b[2] = (test & 2) !=0;
      b[3] = (test & 4) !=0;
      b[4] = (test & 8) !=0;
      b[5] = (test & 16) !=0;
      b[6] = (test & 32) !=0;
      b[7] = (test & 64) !=0;
      b[8] = (test & 128) != 0;
      for(int i=1;i<=8;i++)
      {
        System.out.print(b[i]+" ");
      }
      System.out.println("\n");
    return;
}