List<List<String>> output = new ArrayList<>();
for(int i=0; i<CharList.size(); i++) output.add(new ArrayList<String>());

int startIndex=0;
int charPointer=0;              
while(startIndex < recordList.size() && charPointer < CharList.size())
{
    String charStr = CharList.get(charPointer);
    String recStr = recordList.get(startIndex);

    int cmp;
    if(recStr.length() < charStr.length()) 
    {
        cmp = -1;
    }
    else
    {
        String recSubStr = recStr.substring(0, charStr.length());           
        cmp = recSubStr.compareToIgnoreCase(charStr);           
    }

    if(cmp <= 0)
    {
        if(cmp == 0) output.get(charPointer).add(recStr);
        startIndex++;
    }
    else 
    {
        charPointer++;
    }
}

for(int i=0; i<CharList.size(); i++)
{
    System.out.println(CharList.get(i) + " : " + output.get(i));
}