String com = command.get(0);
if (com.equals(open)) {
    OpenCommand.execute()
} else if (com.equals(saveas)) {
    SaveCommand.execute();
} ...