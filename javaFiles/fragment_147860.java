Dumper device;

...

public MultiThreaded(Dumper device) {
  this.device = device;
}

public void execute_input() {
  ...
  device.status = status;
}