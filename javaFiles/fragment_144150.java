Path cityInputPath = new Path(args[1]);
Path countryInputPath = new Path(args[2]);
Path outputPath = new Path(args[3]);
MultipleInputs.addInputPath(job, countryInputPath, TextInputFormat.class, JoinCountryMapper.class);
MultipleInputs.addInputPath(job, cityInputPath, TextInputFormat.class, JoinCityMapper.class);
FileOutputFormat.setOutputPath(job, outputPath);