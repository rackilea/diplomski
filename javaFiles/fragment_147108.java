List<EClass> cmdClasses = EcoreHelper.getAllClassesInheritFrom("Command");
    for(EClass cmdClass : cmdClasses){
        newChildDescriptors.add
        (createChildParameter
            (CommandPackage.Literals.COMMAND__COMMANDS,
             EcoreHelper.createClassByName(cmdClass.getName())));
    }