public String findClosestZone(Location target)
    {
        int counter = 0;
        String closeZip = COLLECTION_EMPTY;
        double closestDistance = 100.0;
        for (int i = 0; i < this.zoneCount; i++)
        {
            if (this.zones[i].getZoneLocation().calcDistance(target) < closestDistance)
            {
                closeZip = this.zones[i].getZoneZipCode();
                closestDistance = this.zones[i].getZoneLocation().calcDistance(target);
                counter++;
                // return closeZip;
            }
        }
        return closeZip;
    }