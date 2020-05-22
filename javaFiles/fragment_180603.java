File originalFile = new File(<file parent path>, "myxmlfile");
File cloneFile = new File(originalFile.getParent(),
         originalFile.getName()+"<anything_i_want_to_add>");
Files.copy(originalFile.toPath(),cloneFile.toPath());
//now your new file exist and you can use it
originalFile.delete();//you delete the original file
...
//after you are done with everything and you want the path back
Files.copy(cloneFile.toPath(),originalFile.toPath());
cloneFile.delete();