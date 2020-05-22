public static void agentFieldConstructor(Agent agent, String nodeName, String value) {
    try {
        agent.getClass().getDeclaredMethod("set" + nodeName, value.getClass()).invoke(agent, value);
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        e.printStackTrace();
    }
}