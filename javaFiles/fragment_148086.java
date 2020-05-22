String [] lines = ...
for (int i = 0; i < N; i++){
   // delegate to a utility class LineBuilder (perhaps an extension of StringBuilder) to concatenate lines
   // this class would still need to check a condition e.g. for the first line to skip the "\n"
   // since we have delegated the decisions we do not have two code parts inside the loop
   lineBuilder.addLine( lines[i] );
}