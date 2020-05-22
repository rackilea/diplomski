MultipleInputs.addInputPath(jobConf, 
                     new Path(csvFilePath),       
                     SequenceFileInputFormat.class, 
                     CSVProcessingMapper.class);
MultipleInputs.addInputPath(jobConf, 
                     new Path(xmlFilePath), 
                     XmlInputFormat.class, 
                     XMLProcessingMapper.class);