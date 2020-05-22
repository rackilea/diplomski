BufferedReader br = new BufferedReader(...);
try {
    ...
} catch (...) {
    ...
} finally {
    br.close(); // br will definitely not be null
}