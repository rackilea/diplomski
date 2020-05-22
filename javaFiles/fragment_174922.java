@Override
    public void updateLineDetails(LineDetailsInfo lineDetailsInfo) {
        Session session = this.sessionFactory.getCurrentSession();

        PlantDetails pd = (PlantDetails)session.createQuery("from PlantDetails where plant = :plant")
                                 .setString("plant", lineDetailsInfo.getPlant()).uniqueResult();
        LineDetails existinglineDetails = (LineDetails) session.get(LineDetails.class, 
        lineDetailsInfo.getLineId());
        existinglineDetails.setLineName(lineDetailsInfo.getLineName());
        existinglineDetails.setPlantDetails(pd);

       existinglineDetails.setLineDescription(lineDetailsInfo.getLineDescription())

        session.update(existinglineDetails);
    }