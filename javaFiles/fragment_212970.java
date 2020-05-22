package husalgo;

import java.util.Arrays;
import javax.swing.JOptionPane;


public class HusAlgo 
{
    private static final int numJobs = 5;
    static int[] lev = new int[numJobs];
    private static final int[][] adj = new int[numJobs][numJobs];

    public static void main(String[] args) 
    {
        int lev = 0;
        int root = 0;

        int numJobs = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter number of jobs: "));
        int machines = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter number of machines: "));        
        int[] begin = new int[numJobs - 1];
        int[] end = new int[numJobs - 1];

        //Grab input for the begining and ending arcs
        for (int i = 0; i < begin.length; i++) 
        {
            begin[i]  = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the begining arc for job " + (i + 1) + ": "));  
            end[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter ending arc for job " + (i + 1) + ": "));            
        }       

        //Setup adjacency matrix
        for (int i = 0; i < numJobs; i++) 
        {
            for (int j = 0; j < numJobs; j++) 
            {
                adj[i][j] = 0;
            }

        }

        for (int i = 0; i < numJobs - 1; i++) 
        {
            adj[begin[i]][end[i]] = 1;
        }

        level(root, lev);      
    }

    public static void level(int root, int l)
    {        

        for (int i = 0; i < numJobs; i++) 
        {
            if (adj[i][root] == 1) 
            {
                lev[i] = l + 1; 
                level(i, l + 1);
            }
        }

        System.out.println("Levels: " + Arrays.toString(lev));
    }

}