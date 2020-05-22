public static List<String> getTeamMembers(final String teamLeader) 
{
     final List<String> result = new ArrayList<>(); // fullTeamMembers
     final List<String> teamMembers = teamMembersMap.get(teamLeader); // Can be NULL or empty

     if (teamMembers == null || teamMembers.isEmpty())
          return result; // Return empty array

     // Else, carry on
     result.addAll(teamMembers);

     for (String teamMember : result) 
          if ( !teamMember.equalsIgnoreCase("") ) 
               return getTeamMembers(teamMember); // Go recursively if not ""

     // Return result from map
     return result;
}