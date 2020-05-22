String input = "Rover file: AA-123-12345-SP1.SSF\n" +
               "Local time: 2/11/2014 8:06:30 PM to 2/11/2014 8:37:15 PM\n" +
               "100% total coverage\n" +
               "100% coverage by guug04314054.zip\n" +
               "Rover file: AA-321-54321-SP1.SSF\n" +
               "Local time: 2/3/2015 4:06:14 PM to 2/3/2015 4:06:44 PM\n" +
               "0% total coverage. No matching base data found.\n" +
               "Rover file: AA-132-12354-SP2.SSF\n" +
               "Local time: 2/17/2014 5:51:01 PM to 2/17/2014 6:18:57 PM\n" +
               "100% total coverage\n" +
               "4% coverage by guug04914003.zip\n" +
               "100% coverage by guug04914022.zip\n";
try (BufferedReader in = new BufferedReader(new StringReader(input))) {
    new LogEntry().process(in);
}