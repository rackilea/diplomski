public void test45PercentLoad() {
  LoadParser p = new LoadParser();
  InputStream in = getClass().getResourceAsStream("cpuUsageSample45percentLoad.txt");
  p.read(in);
  assertEquals(45, p.getLoadPercentage());
}

public void testProgramCall() {
  Process p = MachineLoadMeter.callExternalProgram();
  assertEquals("process is terminated", !p.isAlive());
  assertEquals("exit value 0 means some program was run", 0, p.exitValue());
  // maybe test the process output for some string patterns
  // that are always present, to check that the correct external program
  // was run
}

/**
 * Run everything together, but only test basics.
 */
public void testMachineLoadMeter() {
  int v = MachineLoadMeter.getCurrentLoadPercentage();
  assertTrue(v >= 0 && v <= 100);
}