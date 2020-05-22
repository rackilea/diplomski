Process p = new ProcessBuilder(
    "curl",
    "-H", "Content-Type: text/plain",
    "-d", "#Genes\nPIK3C2A\nPTEN\nUNC5B",
    "-X", "POST",
    "--url", "https://reactome.org/AnalysisService/identifiers/projection/"
).start();