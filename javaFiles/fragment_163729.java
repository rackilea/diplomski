// Let subClass instances run normally...
cec.setActive(true);
letThemDoSomething("BEFORE", sbc1, sbc2, sbc3);

// Now change existing scenario...
cec.setActive(false);
letThemDoSomething("AFTER", sbc1, sbc2, sbc3);