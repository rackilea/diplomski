new ProcessExecutor().command("python", "script.py")
    .redirectOutput(new LogOutputStream() {
        @Override
        protected void processLine(String line) {
            ...
        }
    })
    .execute();