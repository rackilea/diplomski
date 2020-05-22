package parsing;

import java.io.*
import java.util.*

public class ScriptParser implements Parser {

private static ArrayList<String> listOfQueries = null;

@Override
public ArrayList<String> createQueries(String path) {
    String queryLine = new String();
    StringBuilder sBuffer = new StringBuilder();
    listOfQueries = new ArrayList<>();
    List<String> dirtyQueries = new ArrayList<>();

    try {
        FileReader fr = new FileReader(new File(path));
        BufferedReader br = new BufferedReader(fr);
        while ((queryLine = br.readLine()) != null) {
            if (queryLine.contains("--") || queryLine.contains("/*")) {
                queryLine = "";
                dirtyQueries.add(queryLine);
            } else {
                dirtyQueries.add(queryLine + " ");
            }
        }
        br.close();
        for (Iterator<String> iter = dirtyQueries.listIterator(); iter.hasNext();) {
            //TODO
            String str = iter.next();
            if (str.isEmpty() || str.trim().isEmpty()) {
                iter.remove();
            } else {
                //DO NOTHING
            }
        }

        StringBuilder queryStatement = new StringBuilder();
        for (int i = 0; i < dirtyQueries.size(); i++) {
            //TODO
            if (!dirtyQueries.get(i).contains("GO") || !dirtyQueries.get(i).contains("GO ")) {
                queryStatement.append(dirtyQueries.get(i)).append(" ");
            } else {
                listOfQueries.add(queryStatement.toString());
                queryStatement = new StringBuilder();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(sBuffer.toString());
    }
    return listOfQueries;
  }
}