Transaction trans = new Transaction();      
    trans.setAmount(new Double(10001));

    // define commands
    InsertObjectCommand insertObjectCommand = new InsertObjectCommand(trans, "InputTransaction");

    GetObjectsCommand getObjectsCommand = new GetObjectsCommand();
    getObjectsCommand.setOutIdentifier("objects");

    FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand("RunAllRules");

    // insert commands into Command object (BatchExecutionCommand)
    List<GenericCommand<?>> commands = new ArrayList<GenericCommand<?>>();
    commands.add(insertObjectCommand);
    commands.add(fireAllRulesCommand);
    commands.add(getObjectsCommand);
    BatchExecutionCommand command = new BatchExecutionCommandImpl(commands);

    String xStreamXml = BatchExecutionHelper.newXStreamMarshaller().toXML(command); // actual XML request