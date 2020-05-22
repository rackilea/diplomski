private static List<Member> 
convertToFlatList(List<Member> memberList, List<Member> flatList)
{
    for (Member member : memberList)
    {
        // Always add the member to flatList
        flatList.add(memeber);

        // If it has children, add them toore
        if (member.getChildren() != null)
        {
            convertToFlatList(member.getChildren(), flatList);
        }
    }
    return flatList;
}