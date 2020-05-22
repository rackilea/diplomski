Roshambo rock = new Roshambo("ROCK");
Roshambo scissors = new Roshambo("SCISSORS");
Roshambo paper = new Roshambo("PAPER");
rock.beats = scissors;
scissors.beats = paper;
paper.beats = rock;

GsonBuilder gsonBuilder = new GsonBuilder();
new GraphAdapterBuilder()
    .addType(Roshambo.class)
    .registerOn(gsonBuilder);
Gson gson = gsonBuilder.create();

assertEquals("{'0x1':{'name':'ROCK','beats':'0x2'}," +
    "'0x2':{'name':'SCISSORS','beats':'0x3'}," +
    "'0x3':{'name':'PAPER','beats':'0x1'}}",
    gson.toJson(rock).replace('\"', '\''));