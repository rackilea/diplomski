public class StorySynthesiser  {

    public static void main(String[] args) {

        String message=""; // initailize your message here
        String name ="Tiger";
        message = message +"There once was a speedy Hare who bragged about how fast he could run.\n";
        message = message +"Tired of hearing him boast, the Tortoise challenged him to a race.\n";
        message = message +"All the animals in the forest gathered to watch.\n";
        message = message +"The Hare ran down the road for a while and then paused to rest. \n";
        message = message +"He looked back at the tortoise and cried out, \"How do you expect to win this race when you are walking along at your slow, slow pace?\n";
        message = message +"The Tortoise walked and walked, never ever stopping until he came to the finish line.\n";       
        message = message +"The animals who were watching cheered so loudly for Tortoise that they woke up the Hare. The Hare stretched, yawned and began to run again, but it was too late.\n";
        message = message +"Tortoise had already crossed the finish line in 2 hours ago/n";
String result = message.replaceAll("Hare", name);
    System.out.println(result);

    }}