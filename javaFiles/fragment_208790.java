static List<Process> doPipeJava9() throws IOException {
    return ProcessBuilder.startPipeline(
        List.of(new ProcessBuilder("cmd", "/S/D/c", "dir", "/s/b", ".")
                    .redirectInput(ProcessBuilder.Redirect.INHERIT)
                    .redirectError(ProcessBuilder.Redirect.INHERIT),
                new ProcessBuilder("cmd", "/S/D/c", "findstr", "dat$")
                    .redirectErrorStream(true)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)) );
}