public static void main(String[] args)
{
    Stream<String> flat = Stream.of("Start of log entry 1",
                                    "    ...some log details",
                                    "    ...some log details",
                                    "Start of log entry 2",
                                    "    ...some log details",
                                    "    ...some log details",
                                    "Start of log entry 3",
                                    "    ...some log details",
                                    "    ...some log details");

    StreamSplitter.streamOf(flat, line -> line.matches("Start of log entry.*"))
                  .forEach(logEntry -> {
                      System.out.println("------------------");
                      logEntry.forEach(System.out::println);
                  });
}

// Output
// ------------------
// Start of log entry 1
//     ...some log details
//     ...some log details
// ------------------
// Start of log entry 2
//     ...some log details
//     ...some log details
// ------------------
// Start of log entry 3
//     ...some log details
//     ...some log details