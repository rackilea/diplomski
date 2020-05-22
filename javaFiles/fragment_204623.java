private Queue<String> qCommands; // global

public void onCreate(...){
    qCommands = new ArrayDeque<>();
    // read SMS' text
    qCommands.add(command[i]);     // everytime I read a command
    // same as before but without for(i->nCommands) and switch command[i]
    nextCommand(qCommands.poll());
}

public void nextCommand(String command){
    if(command != null){
        switch (command) {
            case "-SHOTPHOTO":
            // finds the correct file name of this command
            shotphoto(files[j]);
            break;
        case "-SENDPHOTO":
            // finds the correct file name of this command  
            sendphoto(files[j]);
            break;
        }
    } else {
        // the queue is empty so no more commands
}

// both shotphoto() and sendphoto() start an Activity for result so when they have finished onActivityResult will be called
public void onActivityResult(...){
    if(resultcode == SHOTPHOTO)
        nextCommand(qCommands.poll());
    if(resultcode == SENDPHOTO)
        nextCommand(qCommands.poll());
}