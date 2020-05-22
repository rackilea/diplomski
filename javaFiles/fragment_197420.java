IMethod methodToRename = <....>
RenameMethodProcessor processor = new RenameVirtualMethodProcessor(methodToRename)
processor.setUpdateReferences(true);
processor.setNewElementName("newMethodName");

RenameRefactoring fRefactoring = new RenameRefactoring(processor);
fChange= fRefactoring.createChange(new NullProgressMonitor());
fChange.initializeValidationData(new NullProgressMonitor());
fChange.perform(new NullProgressMonitor())