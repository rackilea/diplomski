import org.json.*;
.
.
.
Double[][] test2 = new Double[5][2];
test2[1][1]= 0.1;
test2[1][0]= 0.2;
test2[2][1]= 0.2;
test2[2][0]= 0.2;
test2[3][1]= 0.1;
test2[3][0]= 0.2;
test2[4][1]= 0.2;
test2[4][0]= 0.2;
test2[0][1]= 0.2;
test2[0][0]= 0.2;

out.println(new JSONArray(test2).toString());