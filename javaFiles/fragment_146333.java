public interface Command {
     void exec();
}

public class Copy implements Command {    
     void exec() {
          // your copy Code 
     }
}

public class Paste implements Command {    
     void exec() {
          // your Paste Code 
     }
}


public class Delete implements Command {    
     void exec() {
          // your Delete Code 
 }