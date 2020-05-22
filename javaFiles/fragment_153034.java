OptionParser parser = new OptionParser("a::b?*");
    parser.allowsUnrecognizedOptions();

//  In case the user specifies a path instead of just running the command 
//  locally, create an array out of the parsed directory strings.
String[] dirStringArray = options.nonOptionArguments().toArray(new String[options.nonOptionArguments().size()]);