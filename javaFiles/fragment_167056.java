switch (cmd[0]) {
    case "exit":
        running = false;
        System.out.println("Shutting down...");
        break;
    default:
        if(commands.contains(cmd[0])) {
            commands.get(cmd[0]).eval(cmd);
        } else {
            System.out.println("Unknown command");
        }
        break;
}