ExpectJ exp = new ExpectJ(10);
String cmd = "sh test.sh";
Scanner sc = new Scanner();
Spawn s = exp.spawn(cmd);
s.expect("Name");
String answer1 = sc.next();
s.send(answer1 + "\n);
s.expect("Password");
String answer2 = sc.next();
s.send(answer2+"\n");
.
.
.
//and so on...