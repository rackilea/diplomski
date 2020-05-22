/**
     * Number of passengers who survived the sinking of the Titanic as a
     * function of the passenger class (e.g. 1,2,3)
     *
     * @param cls
     * @return
     */
    public int getTotalNumberofSurvivedPassengersByClass(int cls) {
        int count = 0;
        for (int i = 0; i < getTotalPassengers(); i++) {
            int status = Integer.parseInt(data[i][1]);
            int clazz = Integer.parseInt(data[i][0]);
            //Survived (1 = yes, 0 = no)
            if (status == 1 && clazz == cls) {
                count++;
            }
        }
        return count;