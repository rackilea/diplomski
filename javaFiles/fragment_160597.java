String myKey="/home/local/my_key.pem";
Runtime runtime = Runtime.getRuntime();
String commande = "ssh -i "+myKey+" ubuntu@ec2-53-71-22-288.eu-west-1.compute.amazonaws.com 'bash ./runFile.bash' -o StrictHostKeyChecking=no ";

Process p = runtime.exec(commande);
p.waitFor();