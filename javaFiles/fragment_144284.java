// tmp2 == "45" (taken from your comment)

preresult = Integer.parseInt(tmp2.substring(0, 1)) + Integer.parseInt(tmp2.substring(1, 2));
//                           |------ "4" -------|                     |-------- "5" -----|
//          |--------------- 4 -----------------|    |------------------ 5 --------------|
// preresult == 4 + 5 == 9

println(tmp2); // prints the "45" (unchanged)

tmp2 = Integer.toString(preresult) + tmp2.substring(2, tmp2.length());
//                      |-- 9 --|                     |"45"|
//     |----------- "9" ---------|   |------------- "" -------------|
// tmp2 == "9" + "" == "9"

println(tmp2); // prints "9"