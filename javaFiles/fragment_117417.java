handlers = 1spring.org.apache.juli.FileHandler, java.util.logging.ConsoleHandler        

1spring.org.apache.juli.FileHandler.level = SEVERE

1spring.org.apache.juli.FileHandler.directory = ${catalina.base}/logs
1spring.org.apache.juli.FileHandler.prefix = springframework.

java.util.logging.ConsoleHandler.level = SEVERE  
java.util.logging.ConsoleHandler.formatter = java.util.logging.SimpleFormatter      

org.springframework.handlers = 1spring.org.apache.juli.FileHandler, java.util.logging.ConsoleHandler