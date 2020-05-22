@Column(name = "created_at", length = 19)
public Timestamp getCreatedAt() {
    return this.createdAt;
}

setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));