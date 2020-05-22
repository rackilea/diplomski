String[] commands = {
            "echo 'test' >> /sdcard/test1.txt",
            "echo 'test2' >>/sdcard/test1.txt"
    };

    execCommands(commands);

    String commandText = "echo 'foo' >> /sdcard/foo.txt\necho 'bar' >> /sdcard/foo.txt";

    execCommands(commandText.split("\n"));