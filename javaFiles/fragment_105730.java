Combo wField = new Combo();
            String[] inputFields = transMeta.getPrevStepFields(stepname).getFieldNames();
            Arrays.sort(inputFields);

            for (String fName : inputFields) {
                wField.add(fName);
            }