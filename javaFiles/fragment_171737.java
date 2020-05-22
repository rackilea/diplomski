String str = "rdl_mod_id:0123456789\n\nrdl_mod_name:Driving Test\n\nrdl_mod_type:PUBL\n\nrdl_mod_mode:Practice\n\nrdl_mod_date:2013-04-23";
        Pattern pattern = Pattern.compile("rdl_mod_name:(.*?)\n");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }