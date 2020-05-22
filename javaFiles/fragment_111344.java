while(line == null){
        writer.write("xdotool search --onlyvisible --name " + name + "\n");
        writer.flush();
        if(reader.ready())
            line = reader.readLine();

        Thread.sleep(1000);
}