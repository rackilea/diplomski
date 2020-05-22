package hamiltonian_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class Main {

    int[] solution;
    HashMap<Integer, List<Integer>> candidates;

    public static void main(String args[]) {
        Main main = new Main();
        main.solution = new int[10];//stores the solution; index 0 is not used, i will use indexes from 1 to 9
        main.candidates = new HashMap<Integer, List<Integer>>();//for each position (1 to 9) in the solution, stores a list of candidate elements for that position

        List<Integer> oneToNine = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        /*
         * because no solution can start from matrix elements 2,4,6 or 8, 
         * for the sake of optimization, the above list can be written as
         * Arrays.asList(1,3,5,7,9)
         * the way it is right now is useful to follow the way the program 
         * does the backtracking, when it accidentally starts with either 2,4,6 or 8
         */
        Collections.shuffle(oneToNine);//a random permutation of the list
        main.candidates.put(1, oneToNine);
        main.buildSol(1);

    }

    //backtracking
    public void buildSol(int k)
    {
        if(k==10)
        {
            System.out.print("the solution is ");
            printSolution();
            return;
        }

        List<Integer> candList = candidates.get(k);
        if(candList.isEmpty())
        {
            cleanSolution(k);
            buildSol(k-1); //if no candidates for current step, go one step back
        }
        else
        {
            int firstCandidate = candList.get(0);
            candList.remove(0);
            candidates.put(k, candList);
            solution[k] = firstCandidate;//for the position k in the solution, pick the first element in the candidates list

            List<Integer> neighbors = getNeighbors(solution[k]);
            List<Integer> prevElems = getPreviousElementsInSolution(k);
            candidates.put(k+1, generateCandidates(neighbors, prevElems));//while being at step k, generate candidate elements for step k+1
            //these candidates are the neighbors (in the matrix) of the current element (solution[k]), 
            //which are not already part of the solution at an earlier position

            System.out.println("step "+k);
            System.out.print("partial solution: ");
            printSolution();
            System.out.println();


            buildSol(k+1);//go to next step
        }
    }



    //candidates are those elements which are neighbors, and have not been visited before
    public List<Integer> generateCandidates(List<Integer> neighbors, List<Integer> previousElements) 
    {
        List<Integer> cnd = new ArrayList<Integer>();
        for(int i=0;i<neighbors.size();i++)
            if(!previousElements.contains(neighbors.get(i)))
                cnd.add(neighbors.get(i));

        return cnd;
    }

    //get the set of previous elements in the solution, up to  solution[k]
    public List<Integer> getPreviousElementsInSolution(int step)
    {
        List<Integer> previousElements = new ArrayList<Integer>();
        for(int i=1; i<=step-1;i++)
            previousElements.add(solution[i]);

        return previousElements;
    }

    //get neighbors of the matrix element which corresponds to solution[k]

    public  List<Integer> getNeighbors(int element) {

        List<Integer> neighboursList = new ArrayList<Integer>();

        switch (element) {

            case 1: neighboursList = Arrays.asList(2, 4);
                    break;

            case 2: neighboursList = Arrays.asList(1, 3, 5);
                    break;

            case 3: neighboursList = Arrays.asList(2, 6);
                    break;

            case 4: neighboursList = Arrays.asList(1, 5, 7);
                    break;

            case 5: neighboursList = Arrays.asList(2, 4, 6, 8);
                    break;

            case 6: neighboursList = Arrays.asList(3, 5, 9);
                    break;

            case 7: neighboursList = Arrays.asList(4, 8);
                    break;

            case 8: neighboursList = Arrays.asList(5, 7, 9);
                    break;

            case 9: neighboursList = Arrays.asList(6, 8);
                    break;

            default: neighboursList = new ArrayList<Integer>();
                    break;
        }

        return neighboursList;
    }



    public void printSolution()
    {
        for(int i=1;i<solution.length;i++)
            System.out.print(solution[i]+" ");
    }

    public void cleanSolution(int k)
    {
        for(int i=k;i<solution.length;i++)
            solution[i]=0;
    }
}