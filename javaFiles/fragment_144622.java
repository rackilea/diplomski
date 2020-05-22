Calendar c = ...;
String s = String.format("Duke's Birthday: %1$tm %1$te,%1$tY%n", c); 
//Note `%n` at end of line                                  ^^

String s2 = String.format("Use %%n as a platform independent newline.%n"); 
//         %% becomes %        ^^
//                                        and `%n` becomes newline   ^^