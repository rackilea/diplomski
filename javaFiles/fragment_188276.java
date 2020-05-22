String string[] = {"advmod(likes-4, also-3)",// ==> advmod , likes , also
        "nsubj(likes-4, dog24-2)",// ==> bsubj , likes , dog24
        "num(dog24-3, 8-2)"};//==> num ,dog24 , 8
Pattern p = Pattern.compile("(\\w+)\\(([^-]+).*, ([^-]+)");
for (int i = 0; i < string.length; i++) {
    Matcher m = p.matcher(string[i]);
    while(m.find()) {
        System.out.print(i+": ");
        for(int j=1; j<= m.groupCount(); j++){
            System.out.print(m.group(j));
            if(j!=m.groupCount()) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
}