IFolder folder = IProject.getFolder("src/model");
IResource[] members = folder.members();
for(IResource member: members) {
  if (member instanceof IFile && member.getFileExtension().equalsIgnoreCase("model") {
    file = (IFile)member;
    break;
  }
}