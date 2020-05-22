String[] args = ...; // options and parameters as they appear on a command line
int done = 0;
while( done < args.length ){
    int eaten = 0;
    try {
        eaten = sc.getOptions().parseArgument( args, done );
    } catch( com.sun.tools.xjc.BadCommandLineException bcle ){
        // handle the exception
    } finally {
        done += eaten;
    }
    if( eaten == 0 ) break;  // not recognized, can't continue, abort
}