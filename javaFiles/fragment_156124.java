String[] tests = {
        "a,b,c,d,e,f",
        "a,b,~c~,d,e",
        "~a,b,c,d,e~",
        "a,b,c,~d,e,f~,g,h,i,~j,k,l,~m,n,o~,q,r,~s,t,u",
    };
    for (String test : tests) {
        System.out.println(
            test.replaceAll(
                "(^[^~]*~)|([^~]*$)|([^,~]*),|([^,~]*~[^~]*~)",
                "$1$2$3$4"
            )
        );
    }