DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS",
                    Locale.US);
            String s1 = "2011-11-19T00:00:00.000-03:00";
            Date d;
            try
            {
                d = sdf.parse(s1);
                String s2 = (new SimpleDateFormat("yyyyMMdd")).format(d);
                System.out.println(s2);
            }
            catch (ParseException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }