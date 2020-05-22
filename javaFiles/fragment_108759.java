MainBuilder builder = new MainBuilder();

builder.setValue(100);
// all following Main's will have a value of 100
Main mainOne = builder.build();
Main mainTwo = builder.build();

builder.setValue(200);
// all following Main's will have a value of 200
Main mainThree = builder.build();
Main mainFour = builder.build();