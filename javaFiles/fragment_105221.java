ProcessBuilder compileProcessBuilder = new ProcessBuilder(cmds);

// redirect all IO separately
compileProcessBuilder.redirectInput(ProcessBuilder.Redirect.INHERIT);
compileProcessBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
compileProcessBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

// or use a convenient call for all at once (thanks VGR to mention it)
compileProcessBuilder.inheritIO();

Process compileProcess = compileProcessBuilder.start();