import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Boogle {

    LinkedList<Position<Character>> list = new LinkedList<>();

    LinkedList<Position<Character>> table = new LinkedList<>();
    Map indexMap = new HashMap();
    static QuadHashTable<String> table = new QuadHashTable<>();

    String word;

    static char matrix [] [] = {

        {'a', '-', '-', '-'},
        {'a', 'r', 'o', '-'},
        {'-', '-', 'n', '-'},
        {'-', '-', '-', '-'}
    };

    public Boogle () {

        this(null);
    }

    public Boogle (char matrix [] []) {

        this.matrix = matrix;

    }

    public boolean hasWord(String s) {

        return s.equals(table.search(s));

    }

    public void findWordsUtil(char boggle[][], boolean visited[][], int i,
                              int j, String str)
    {

        visited[i][j] = true;
        str = str + boggle[i][j];


        if (hasWord(str))
        {
            for (char c : str.toCharArray())
            {            
                ArrayList coordinates = (ArrayList)indexMap.get(c);
                String xy = (String)coordinates.get(0);                

                if(coordinates.size() !=1) // or check with flag in visited matrix 
                {
                    coordinates.remove(xy);
                    indexMap.put(c,coordinates);                    
                }

                String [] rowCol = xy.split(":");
                int x = Integer.parseInt(rowCol[0]);
                int y = Integer.parseInt(rowCol[1]);                        

                Position<Character> pos = new Position<>(c, x, y);
                list.add(pos);
            }
            return;


        }


        for (int row = i - 1; row <= i + 1 && row < 4; row++)
            for (int column = j - 1; column <= j + 1 && column < 4; column++)
                if (row >= 0 && column >= 0 && !visited[row][column])
                    findWordsUtil(boggle, visited, row, column, str);
        visited[i][j] = false;
    }

    public LinkedList<Position<Character>> solve () {

        String s = "";

        boolean visited[][] = new boolean[4][4];


        String str = "";

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
            {
                if(indexMap.get(matrix[i][j])!=null)
                {
                    ArrayList list = (ArrayList) indexMap.get(matrix[i][j]);
                    list.add(i+":"+j);
                    indexMap.put(matrix[i][j],list);
                }else if(matrix[i][j]!='-')
                {
                    ArrayList list = new ArrayList();
                    list.add(i+":"+j);
                    indexMap.put(matrix[i][j],list);
                }

            }



        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                findWordsUtil(matrix, visited, i, j, str);



        return list;
    }

    public static void main (String args []) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/home/dsolipa/Desktop/allWords.txt"));

        String line;

        while((line = br.readLine()) != null) {

            table.insert(line);
        }

        Boogle boogle = new Boogle(matrix);

        System.out.println(boogle.solve());

        //System.out.println(boogle.hasWord("or"));

    }
}