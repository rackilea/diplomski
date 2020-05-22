jar cvf egPriv.jar egPriv
jar cvf eg.jar eg


echo 'Restricted' > ..\file.txt
java -cp eg.jar;egPriv.jar -Djava.security.manager -Djava.security.policy=sample.policy  eg.Cat ..\file.txt

echo 'Open' > file.txt
java -cp eg.jar;egPriv.jar -Djava.security.manager -Djava.security.policy=sample.policy  eg.Cat file.txt