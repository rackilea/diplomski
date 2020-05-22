if (!PRlist.get(i).isAlive()){
    int exitCode=PRlist.get(i).exitValue();
    //Do something with exitValue

    PRlist.get(i).destroy();
    PRlist.get(i).destroy();
    PRlist.remove(i);
    try {
        Process PR = new ProcessBuilder().inheritIO().command(commandsList.get(i)).redirectInput(Redirect.INHERIT).start();
        System.out.println(commandsList.get(i)[12] + " stream re-established at " + LocalDateTime.now().format(frmt));
         PRlist.add(i,PR);
         } catch (IOException ex) {ex.printStackTrace();}
         }