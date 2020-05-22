List<String> stepargs = new ArrayList<String>();
stepargs.add("spark-submit");
stepargs.add("--class");
stepargs.add(mainClass);
stepargs.add("--deploy-mode");
stepargs.add("cluster");
stepargs.add("--master");
stepargs.add("yarn");
stepargs.add("--files");
stepargs.add(files);
stepargs.add("--jars");
stepargs.add(jars);
stepargs.add("--properties-file");
stepargs.add(confFileName);
stepargs.add(jar);
Iterator<String> itr = args.iterator();
while (itr.hasNext()) {
    String arg = itr.next();
    if (arg.equals("--arg")) {
        stepargs.add(itr.next());
    }
}