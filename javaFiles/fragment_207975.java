CommandLine cmdLine = new CommandLine("cmd.exe");
                    cmdLine.addArgument("/c");
                    cmdLine.addArgument(".\\phantomjs\\nk\\batchbin\\casperjs.bat");
                    cmdLine.addArgument(".\\phantomjs\\nk\\batchbin\\dd.js");
                    cmdLine.addArgument(url);
                    cmdLine.addArgument(">" + rand);
                    DefaultExecutor executor = new DefaultExecutor();
                    int exitValue = executor.execute(cmdLine);