public class SearchParameters {
     private String version;
     private String accountId;
     // Other fields

     public static SearchParameters(HttpServletRequest request) {
        // Here you use the getParameterMap of the `request` object to get
        // the query parameters. Look here: http://stackoverflow.com/questions/6847192/httpservletrequest-get-query-string-parameters-no-form-data

        // Everything that was not passed in the parameters
        // just init with default value as you wish.
     }

     // Getters and setters here
}