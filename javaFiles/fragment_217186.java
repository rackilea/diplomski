/**
     * @param lastAccessTime the lastAccessTime to set
     */
    public void setLastAccessTime(Date lastAccessTime)
    {
        lastAccessTime = lastAccessTime == null ? null : new Date(lastAccessTime.getTime());
    }