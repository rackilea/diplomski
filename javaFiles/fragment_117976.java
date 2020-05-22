import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;
    import com.testgson.beans.Example;

    public class Main {
        private static Gson gson;

        static {
            gson = new GsonBuilder().create();
        }

        /**
         * @param args
         */
        public static void main(String[] args) {
             String j = "{\"expand\":\"names,schema\",\"startAt\":0,\"maxResults\":50,\"total\":1,\"issues\":[{\"expand\":\"operations,versionedRepresentations,editmeta,changelog,transitions,renderedFields\",\"id\":\"18200\",\"self\":\"https://localhost/rest/api/2/issue/18200\",\"key\":\"LS-1111\",\"fields\":{\"issuetype\":{\"self\":\"https://localhost/rest/api/2/issuetype/3\",\"id\":\"3\",\"description\":\"A task that needs to be done.\",\"iconUrl\":\"https://localhost/secure/viewavatar?size=xsmall&avatarId=10318&avatarType=issuetype\",\"name\":\"Task\",\"subtask\":false,\"avatarId\":10318},\"timespent\":21600,\"aggregatetimespent\":25200,\"resolution\":null,\"customfield_11201\":null,\"project\":{\"self\":\"https://localhost/rest/api/2/project/10100\",\"id\":\"10100\",\"key\":\"PROJKEY\",\"name\":\"ProjectABCD\",\"avatarUrls\":{\"48x48\":\"https://localhost/secure/projectavatar?pid=10100&avatarId=10600\",\"24x24\":\"https://localhost/secure/projectavatar?size=small&pid=10100&avatarId=10600\",\"16x16\":\"https://localhost/secure/projectavatar?size=xsmall&pid=10100&avatarId=10600\",\"32x32\":\"https://localhost/secure/projectavatar?size=medium&pid=10100&avatarId=10600\"}},\"issuelinks\":[{\"id\":\"16202\",\"self\":\"https://localhost/rest/api/2/issueLink/16202\",\"type\":{\"id\":\"10003\",\"name\":\"Relates\",\"inward\":\"relates to\",\"outward\":\"relates to\",\"self\":\"https://localhost/rest/api/2/issueLinkType/10003\"}}]}}]}";
             Example r = gson.fromJson(j, Example.class);
             System.out.println(r);

// This is how traversal can be done
        List<Issue> issues = r.getIssues();
        for(Issue i: issues) {
            System.out.println("Expand - " + i.getExpand());
            System.out.println("Id - " + i.getId());
            System.out.println("Self - " + i.getSelf());
            System.out.println("Key - " + i.getKey());
            System.out.println("Fields - " + i.getFields());
        }
        }
    }