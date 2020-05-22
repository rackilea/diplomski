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
System.out.println(gson.toJson(rock));