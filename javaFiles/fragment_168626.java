@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((Calendar_Date == null) ? 0 : Calendar_Date.hashCode());
        result = prime * result + Item_Id;
        result = prime * result + ((MRP == null) ? 0 : MRP.hashCode());
        result = prime * result + Stock_Volume;
        result = prime * result + Store_Id;
        result = prime * result
                + ((objectId == null) ? 0 : objectId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Daily_Stock_Pojo other = (Daily_Stock_Pojo) obj;
        if (Calendar_Date == null) {
            if (other.Calendar_Date != null)
                return false;
        } else if (!Calendar_Date.equals(other.Calendar_Date))
            return false;
        if (Item_Id != other.Item_Id)
            return false;
        if (MRP == null) {
            if (other.MRP != null)
                return false;
        } else if (!MRP.equals(other.MRP))
            return false;
        if (Stock_Volume != other.Stock_Volume)
            return false;
        if (Store_Id != other.Store_Id)
            return false;
        if (objectId == null) {
            if (other.objectId != null)
                return false;
        } else if (!objectId.equals(other.objectId))
            return false;
        return true;
    }