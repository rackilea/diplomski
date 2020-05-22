package rpax.stackoverflow.maze13549150;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main13549150 {

    static int steps = 0;
    static int numSteps[][] = new int[8][8];
    static int finx, finy;

    public static void main(String[] args) {
        try
        {

            Scanner s = new Scanner(new File("files/files13549150/DATA4.txt"));
            // for (int q = 0; q < 5; q++)
            // { // I dont know the reason of this loop - Maybe more files?
            char[][] maze = new char[8][8];
            System.out.println("MAZE: ");
            for (int y = 0; y < 8; y++)
            {
                String text = s.nextLine();
                for (int x = 0; x < 8; x++)
                {
                    maze[x][y] = text.charAt(x);
                    System.out.print(maze[x][y] + " ");
                    numSteps[x][y] = Integer.MAX_VALUE;
                }
                System.out.println();
            }
            System.out.println();
            outer:
            for (int z = 0; z < 8; z++)
            {
                for (int a = 0; a < 8; a++)
                {
                    if (maze[a][z] == 'B')
                    {
                        finx = a;
                        finy = z;
                    }
                    if (maze[a][z] == 'A')
                    {
                        System.out.println("BFS: ");
                        System.out.println(bfs2(maze, a, z, '#', 'B'));
                        dfs(a, z, maze, 0, 'B');
                        break outer;
                    }
                }
            }
            System.out.println("DFS: ");
            for (int y = 0; y < 8; y++)
            {

                for (int x = 0; x < 8; x++)
                {
                    if (maze[x][y] == '#')
                    {

                        System.out.print('#' + " ");
                    }

                    else
                        System.out.print(numSteps[x][y] + " ");
                }
                System.out.println();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void dfs(int x, int y, char[][] maze, int steps, char target) {
        if (maze[x][y] == '#')
        {
            return;
        }
        // System.out.println(steps+" "+numSteps[x][y]);
        numSteps[x][y] = Math.min(steps, numSteps[x][y]);
        if (steps > numSteps[x][y])
        {
            return;
        }
        // try {
        if (x > 0)
        {
            dfs(x - 1, y, maze, steps + 1, target);
        }
        if (x < 7)
        {
            dfs(x + 1, y, maze, steps + 1, target);
        }
        if (y > 0)
        {
            dfs(x, y - 1, maze, steps + 1, target);
        }
        if (y < 7)
        {
            dfs(x, y + 1, maze, steps + 1, target);
        }
        if (x > 0 && y > 0)
        {
            dfs(x - 1, y - 1, maze, steps + 1, target);
        }
        if (x > 0 && y < 7)
        {
            dfs(x - 1, y + 1, maze, steps + 1, target);
        }
        if (x < 7 && y < 7)
        {
            dfs(x + 1, y + 1, maze, steps + 1, target);
        }
        if (x < 7 && y > 0)
        {
            dfs(x + 1, y - 1, maze, steps + 1, target);
        }
        // try to avoid this kind of things -> bad practice + breaks recursion
        // } catch (Exception e) {
        // };
    }

    public static int bfs2(char[][] maze, int yStart, int xStart, char wall,
            char goal) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] start = { yStart, xStart, 0 };
        int[][] res = new int[8][8];
        int distanceToGoal = Integer.MAX_VALUE;
        for (int i = 0; i < res.length; i++)
        {
            for (int j = 0; j < res.length; j++)
            {
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        queue.add(start);
        while (queue.peek() != null)
        {

            int[] array = queue.remove();
            int x = array[0];
            int y = array[1];
            if (x < 0 || x >= 8 || y < 0 || y >= 8)
            {
                continue;
            }

            if (maze[x][y] == wall)
            {
                continue;
            }

            // already explored
            if (array[2] >= res[x][y])
            {
                continue;
            }
            res[x][y] = array[2];

            if (maze[x][y] == goal)
            {
                distanceToGoal = array[2] + 1;
                break;
            }

            int[][] newPoints = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 },
                    { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
            for (int i = 0; i < 8; i++)
            {
                int[] temp = { x + newPoints[i][0], y + newPoints[i][1],
                        array[2] + 1 };
                queue.add(temp);
            }

        }
        // testing
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {

                if (maze[j][i] == wall)
                {
                    System.out.print("#" + " ");
                }
                else if (res[j][i] != Integer.MAX_VALUE)
                    System.out.print(res[j][i] + " ");
                else // if not explored
                    System.out.print("." + " ");
            }
            System.out.println();
        }
        return distanceToGoal;

    }
}