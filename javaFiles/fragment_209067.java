Options options = new Options();

OptionGroup group1 = new OptionGroup();
group1.addOption(chgval);
group1.addOption(inputFile);

options.addOption(proc);
options.addOptionGroup(group1);