ProcessBuilder builder = new ProcessBuilder("cl.exe main.cpp /nologo".split("\\s+"));
builder.redirectErrorStream(true);
builder.environment().put("INCLUDE", "C:\\Program Files (x86)\\Microsoft Visual Studio 9.0\\VC\\include;C:\\Program Files (x86)\\Microsoft SDKs\\Windows\\v7.0A\\Include");
builder.environment().put("LIB", "C:\\Program Files (x86)\\Microsoft Visual Studio 9.0\\VC\\lib;C:\\Program Files (x86)\\Microsoft SDKs\\Windows\\v7.0A\\Lib");

Process process = builder.start();

process.waitFor();