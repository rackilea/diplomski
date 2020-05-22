// edge index
class Edge
{
   public int A, B;
   public Edge(int a, int b)
   {
      A = a; B = b;
   }
   public Edge shift(int n)
   {
      return new Edge(A + n, B + n);
   }
}

// cube class
class Cube
{
   // I'll leave out the get-functions etc here
   private float[][] m_verts;
   private Edge[] m_edges;
   public Cube(float[][] v, Edge[] e)
   {
      m_verts = v;
      m_edges = e;
   }
}

Cube cube_N(int dims, float w)
{
   // base case
   if (dims < 1)
      return null;

   // calculate buffer sizes
   int dpow2 = 1 << dims;
   int numVerts = dpow2;
   int numEdges = dims * (dpow2 / 2);

   // buffers
   float[] temp = new float[dims];
   float[][] verts = new float[numVerts][];
   Edge[] edges = new Edge[numEdges];

   // base case creation
   Arrays.fill(temp, w);
   verts[0] = temp.clone();
   edges[0] = new Edge(0, 1);

   // iterative step
   for (int i = 0; i < dims; i++)
   {
      int nV = 1 << i;
      int nE = i * (nV / 2);

      // copy + shift vertices
      for (int j = 0; j < nV; j++)
      {
         float[] v = verts[j].clone();
         v[i] = -w;
         verts[nV + j] = v;
      }

      // copy + shift previous edges
      for (int j = 0; j < nE; j++)
      {
         edges[nE + j] = edges[j].shift(nV);
      }

      // create new edges to join cube copies
      int off = nE * 2;
      for (int j = 0; j < nV; j++)
      {
         edges[off + j] = new Edge(j, nV + j);
      }
   }

   return new Cube(verts, edges);
}