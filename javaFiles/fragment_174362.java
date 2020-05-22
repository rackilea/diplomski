Converter<String, Date> dateConverter = new Converter<String, Date>()
        {
            public Date convert(MappingContext<String, Date> context)
            {
                Date date = null;
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(context.getSource());
                } catch (ParseException e) {
                    System.out.println(e.toString());
                }

                return date;
            }
        };