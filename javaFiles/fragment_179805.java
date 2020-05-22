if (cmd.equals("forward"))
    robot.forward(1);
else if (cmd.equals("turn")) 
    robot.turn();
else
    System.out.println("Unknown command: " + cmd);