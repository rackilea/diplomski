%# compile the Java code
jPath = fullfile(matlabroot,'java','jarext',computer('arch'));
cp = [fullfile(jPath,'jogl.jar') pathsep fullfile(jPath,'gluegen-rt.jar')];
cmd = ['javac -cp "' cp '" HelloWorld.java'];
system(cmd,'-echo')
javaaddpath(pwd)

%# run it
javaMethodEDT('main','HelloWorld','')