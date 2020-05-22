@Override
public boolean equals(final Object obj) {
    if (this == obj) {
        return true;
    } else if (!(HibernateProxyHelper.getClassWithoutInitializingProxy(obj) 
                 instanceof JobStateChange)) {
        return false;
    }

    JobStateChange candidate = (JobStateChange) obj;

    return this.getState() == candidate.getState()
        && this.getActingUser().equals(candidate.getUser())
        && this.getDate().equals(candidate.getDate());
}