String postData = "do_not_disturb=No";

OutputStreamWriter outputWriter = new OutputStreamWriter(uc.getOutputStream());
outputWriter.write(postData);
outputWriter.flush();
outputWriter.close();