List<String>duplicateIds = new ArrayList<String>();
        List<BulkWriteError> errors = mbwe.getWriteErrors();
        for (BulkWriteError error : errors) {

            LOGGER.error("{}", error.getMessage());

            // extract from error.message the id of the duplicated document, (11000 is the duplicate id code)
            if (error.getCode() == 11000) {
                Matcher m = Pattern.compile("[0-9a-f]{24}")
                        .matcher(error.getMessage());
                m.find();
                duplicateIds.add(m.group());
            }

        }
        // here the duplicateIds will hold all the found ids, you can print them in console for example:
        System.out.println(duplicateIds.toString());
        // and do whatever else you like with them