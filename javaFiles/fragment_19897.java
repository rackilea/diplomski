// *nix/MacOS
java -cp antlr-3.2.jar org.antlr.Tool Exp.g   // 1
javac -cp .:antlr-3.2.jar ANTLRDemo.java      // 2
java -cp .:antlr-3.2.jar ANTLRDemo            // 3

// Windows
java -cp antlr-3.2.jar org.antlr.Tool Exp.g   // 1
javac -cp .;antlr-3.2.jar ANTLRDemo.java      // 2
java -cp .;antlr-3.2.jar ANTLRDemo            // 3