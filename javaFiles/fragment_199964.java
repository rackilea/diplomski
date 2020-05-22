*.java Matches a path that represents a file name ending in .java 
*.*    Matches file names containing a dot 

*.{java,class}  Matches file names ending with .java or .class 
foo.?           Matches file names starting with foo. and a single character extension 
/home/*/*       Matches /home/gus/data on UNIX platforms 
/home/**        Matches /home/gus and /home/gus/data on UNIX platforms 
C:\\*           Matches C:\foo and C:\bar on the Windows platform (note that the backslash is escaped; as a string literal in the Java Language the pattern would be "C:\\\\*")