C:\dev\scrap>javac Target.java
C:\dev\scrap>java Target
original-name
C:\dev\scrap>javac -cp .;bcel-6.0.jar Instrumenter.java
C:\dev\scrap>java -cp .;bcel-6.0.jar Instrumenter
C:\dev\scrap>java Target
overriden-name