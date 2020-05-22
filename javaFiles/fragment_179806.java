if ("forward".equals(cmd))
    robot.forward(1);
else if ("turn".equals(cmd)) 
    robot.turn();
else
    System.out.println("Unknown command: " + cmd);