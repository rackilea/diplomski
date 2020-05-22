LinkedList<String> argList = LinkedList<>(Arrays.asList(args));

while(!argList.isEmpty()) {
    switch (argList.pop()) {
        case "-v":
            verbose = true;
            break;
        case "-c":
            configFile = argList.pop();
            break;
        case "-o":
            outputFile = argList.pop();
            break;
        default:
            System.err.println("unknown argument " + arg + " " + val);
            break;
    }
}