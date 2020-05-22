String str= "Hello this is paragraph , Ali@yahoo.com . i am " +
        "entering  random  email here as this one  AHmar@gmail.com " ;

   while (str.contains("@") && str.contains(".")) {

        int index1 = str.lastIndexOf("@");  // Get last index of `@`
        int index2 = str.indexOf(".", index1); // Get index of first `.` after @

        // Substring from index of @ to index of .      
        String serverName = str.substring(index1 + 1, index2);
        System.out.println(serverName);

        // Replace string by removing till the last @, 
        // so as not to consider it next time
        str = str.substring(0, index1);

    }