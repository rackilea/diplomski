List<Agent> agentList = new ArrayList<Agent>();

// for every row add the attributes to agent object and then add the agent object to list

for(looping condition) {

    Agent currentAgent = new Agent();
    currentAgent.setStatus(rs.getString("status"));
    ...
    ...
    ...

    agentList.add(currentAgent);
}