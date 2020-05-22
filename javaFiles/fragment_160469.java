ForceDirectedLayout fdl = new ForceDirectedLayout("graph");
ForceSimulator fs = new ForceSimulator();
fs.addForce(new NBodyForce());
fs.addForce(new DragForce());
fs.addForce(new SpringForce(DEFAULT_SPRING_COEFF, 42));
fdl.setForceSimulator(fs);