ArrayList<String> vars = new ArrayList<String>();

        String toCheck = "var1=val1&&var2=val2&&var3=val3&&var4=val4";

        Pattern p = Pattern.compile("(.*?)=(.*?)&&|(.*?)=(.*?)$");
        Matcher m = p.matcher(toCheck);

        while(m.find()){
            String val = m.group(2);
            if(val == null)
                vars.add((m.group(4)));
            else
                vars.add(val);
        }

        for(int j = 0; j < vars.size(); j++){
            System.out.println(vars.get(j));
        }