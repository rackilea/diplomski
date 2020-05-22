for (Map.Entry<String, Float> entry : sentData_Contacts.entrySet()) 
    {
        sentBarValues.add(i, entry.getValue()); 
        mRenderer.addXTextLabel(i, entry.getKey());
        mRenderer.setXLabels(0);
        i++;
    }