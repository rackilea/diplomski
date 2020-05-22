public String security(String s) {
            System.out.println("connect 1");
            valiDatedString = ESAPI.validator().getValidInput("test", "xxxxx@gmail.com", "Email", 100, false);                
            System.out.println("connect 2"+valiDatedString);
            return valiDatedString
        }