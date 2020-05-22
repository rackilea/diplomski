import java.io.BufferedReader;
import java.io.InputStreamReader;

FileInputStream linesStream = new FileInputStream(pathToFile);
BufferedReader br = new BufferedReader(new InputStreamReader(linesStream));
int threadNum=ctx.getThreadNum();
//skipping lines that belong to other threads
for (int i = 1; i <= threadNum; ++i) {
   br.readLine();
}
String line = br.readLine();
br.close();
linesStream.close();
vars.put("message",line);