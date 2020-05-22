while((line = br.readLine()) != null) {
    try {
    String[] params = line.split(" ");
    prq.add(new Process(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]))),
    ...
    }
    catch(Exception e) {
        //Log
    }
}