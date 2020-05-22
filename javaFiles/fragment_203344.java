public enum AccountType{
    OLD {
       public String type() {
           return "Old account";
       } 
    },
    NEW {
        public String type() {
            return "New account";
        }
    };
 }