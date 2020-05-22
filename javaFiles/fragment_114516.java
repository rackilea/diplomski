SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
format.setTimeZone(TimeZone.getTimeZone("UTC"));

String ldapDate = format.format(Calendar.getInstance().getTime()) + "Z";

System.out.println(ldapDate);