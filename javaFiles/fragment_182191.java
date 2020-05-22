public class Test{

    public static void main(String[] args){
        String data = "{FetchSORDetailsResult=[{SORResData=[{CaseCount=2, MiddleName=M,    SexOffenderIdNumber=429505, DOB=19760619, SexOffenderDatabaseId=NY, Suffix=, Image=http://secure.hallpassid.com/SORPhotos/NY/11152.JPG, FirstName=STEVEN, PhotoIdentifier=11152.JPG, IsAlias=0, LastName=LEVINE}, {CaseCount=1, MiddleName=MARK, SexOffenderIdNumber=179737, DOB=19760619, SexOffenderDatabaseId=FL, Suffix=, Image=http://secure.hallpassid.com/SORPhotos/FL/89346.JPG, FirstName=STEVEN, PhotoIdentifier=89346.JPG, IsAlias=0, LastName=LEVINE}, {CaseCount=2, MiddleName=, SexOffenderIdNumber=429505, DOB=19760619, SexOffenderDatabaseId=NY, Suffix=, Image=http://secure.hallpassid.com/SORPhotos/NY/11152.JPG, FirstName=STEVEN, PhotoIdentifier=11152.JPG, IsAlias=1, LastName=LEVINE}]}]}";
        Pattern pattern = Pattern.compile("\\{[.[^\\{}]]+\\}");
        Matcher matcher = pattern.matcher(data);
        ArrayList<String> matches = new ArrayList<String>();
        while(matcher.find()){
             matches.add(data.substring(matcher.start() + 1, matcher.end() - 1));       // +1-1 to cut off {}
        }
        for(String line : matches){
            for(String fragment : line.split(","))
                System.out.println(fragment.trim());
        }
    }
}