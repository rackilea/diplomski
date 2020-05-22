final Process process = Runtime.getRuntime().exec(command);

process.waitFor();

final result = process.exitValue();

if(0 != result) {
  ...
}