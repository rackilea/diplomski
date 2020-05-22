import java.io.*;
import java.util.*;

public class BellmanFord  {
    LinkedList<Edge> edges;
    int d[], p[];
    int n,e,s;
    final int INFINITY=999;

    private static class Edge  {
        int u,v,w;

        public Edge(int a, int b, int c)     {
            u=a;
            v=b;
            w=c;
        }
    }

    BellmanFord () throws IOException {
        int item;
        edges = new LinkedList<Edge>();
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

        System.out.print("Enter number of vertices ");
        n = Integer.parseInt(inp.readLine());

        System.out.println("Cost Matrix");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)   {
                item = Integer.parseInt(inp.readLine());
                if(item != 0)
                    edges.add(new Edge(i,j,item));
            }
        }

        e = edges.size();
        d = new int[n];
        p = new int[n];

        System.out.print("Enter the source vertex ");
        s = Integer.parseInt(inp.readLine());
    }

    void relax() {
        int i,j;
        for(i=0;i<n;++i) {
            d[i]=INFINITY;
            p[i] = -1;
        }

        d[s] = 0;
        for (i = 0; i < n - 1; ++i) {
            for (j = 0; j < e; ++j) { //here i am calculating the shortest path
                if (d[edges.get(j).u] + edges.get(j).w < d[edges.get(j).v]) {
                    d[edges.get(j).v] = d[edges.get(j).u] + edges.get(j).w;
                    p[edges.get(j).v] = edges.get(j).u;
                }
             }
         }
    }

    boolean cycle() {
        int j;
        for (j = 0; j < e; ++j)
            if (d[edges.get(j).u] + edges.get(j).w < d[edges.get(j).v])
                 return false;
        return true;
    }

    void print() {
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + " has predecessor " + p[i]);
        }
    }

    public static void main(String args[]) throws IOException   {
        BellmanFord  r = new BellmanFord ();
        r.relax();
        if(r.cycle()) {
            for(int i=0;i<r.n;i++)
                System.out.println(r.s+" ==> "+r.d[i]);
        } else {
            System.out.println(" There is a negative edge cycle ");
        }

        r.print();
    }
}