someproject -p out
javac src/com/example/*.java -d out/
cd out/ && jar cfe someproject.jar com.example.Main  com/example/*.class && mv someproject.jar ../ && cd .. 
echo "#!/bin/bash" > someproject
echo 'java -jar $${BASH_SOURCE[0]}.jar' >> someproject
chmod a+x someproject