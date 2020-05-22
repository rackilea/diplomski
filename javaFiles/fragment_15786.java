@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Project project = (Project) o;

    return getId() != null ? getId().equals(project.getId()) : project.getId() == null;
}

@Override
public int hashCode() {
    return getId() != null ? getId().hashCode() : 0;
}