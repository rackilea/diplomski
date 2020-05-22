@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JobTask other = (JobTask)obj;
        if (!Arrays.equals(args, other.args))
            return false;
        return true;
    }