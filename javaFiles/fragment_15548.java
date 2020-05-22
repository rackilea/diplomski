break in else needs to be removed
verify = false;
System.out.println("This word not find in text.");
break;
since after first comparison it will come out of loop with false printed.
keep a boolean variable and set it to true in if block and print the 
answer based on that and we can keep the break in if