/**
 * Just a summary of the class
 */
public class EventQueue {
     private static final int ULTIMATE_PRIORITY = 3;
     private static final int NUM_PRIORITIES = ULTIMATE_PRIORITY + 1;

     private Queue[] queues = new Queue[NUM_PRIORITIES];
     private EventQueue nextQueue;
     private EventQueue previousQueue;
     private EventDispatchThread dispatchThread;
}