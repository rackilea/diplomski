import java.util.Stack;


public class DFS {

    Stack<Integer> st;
      int vFirst;

      int[][] adjMatrix;
      int[] isVisited = new int[7];

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] adjMatrix = { {0, 1, 1, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0 ,0},
                {0, 0, 1, 1, 1, 0, 0}  };


      new DFS(adjMatrix);

    }

    public DFS(int[][] Matrix) {

         this.adjMatrix = Matrix;
         st = new Stack<Integer>();
         int i;
         int[] node = {0, 1, 2, 3, 4, 5, 6};
         int firstNode = node[0];
         depthFirst(firstNode, 7);



          }

          public void depthFirst(int vFirst,int n)
          {
          int v,i;

          st.push(vFirst);

          while(!st.isEmpty())
          {
              v = st.pop();
              if(isVisited[v]==0)
              {
                  System.out.print("\n"+(v+1));
                  isVisited[v]=1;
              }
              for ( i=0;i<n;i++)
              {
                  if((adjMatrix[v][i] == 1) && (isVisited[i] == 0))
                  {
                      st.push(v);
                      isVisited[i]=1;
                      System.out.print(" " + (i+1));
                      v = i;
                  }
              }
          }
}}