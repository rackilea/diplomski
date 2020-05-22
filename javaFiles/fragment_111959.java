public class Node {
     //public static  int inDegree, outDegree, adjNodes[]; // static was causing the problem
     public int inDegree, outDegree, adjNodes[];
    }


public class order{
    private static Node nodes[];

    public static void main(String[] args) throws FileNotFoundException {
        String dataFile = "file.dat";
        indegreeCompute(dataFile);
    }

    private static void indegreeCompute(String dataFile) throws FileNotFoundException {
        Scanner scanFile = new Scanner(new File(dataFile));
        nodes = new Node[scanFile.nextInt()];
        for(int l= 0 ; l <nodes.length ; l++) {
            nodes[l] = new Node();
        }
        while (scanFile.hasNextLine()) {
            scanFile.nextLine();
            int index = scanFile.nextInt();
            System.out.print("node = " + index);
            scanFile.next();
            int NumOutDegree = scanFile.nextInt();
            nodes[index].outDegree = NumOutDegree;
            System.out.print(" outDegree = " + nodes[index].outDegree);
            nodes[index].adjNodes = new int[NumOutDegree];
            scanFile.next();
            System.out.print(" adjNodes = [");
            for ( int i = 0; i < nodes[index].outDegree; i ++ ) {
                nodes[index].adjNodes[i] = scanFile.nextInt();
                if (i < nodes[index].outDegree - 1)
                    System.out.print(nodes[index].adjNodes[i] + ", ");
                else
                    System.out.print(nodes[index].adjNodes[i]);
            }
            System.out.print("]");
            System.out.println();
        }

        for (int i = 0; i < nodes.length; i ++) {
            int outDegree = nodes[i].outDegree;
            for(int k = 0; k < outDegree; k ++) {
                int adjNode = nodes[i].adjNodes[k];
                nodes[adjNode].inDegree ++;
            }
        }
        scanFile.close();
    }
}