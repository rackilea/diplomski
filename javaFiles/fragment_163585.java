package com.example.aop.attributes;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Aspect that adds a timestamp attribute to the entity along with the logic to
 * update that timestamp value just before it gets persisted to the database. It
 * also adds a creation timestamp to track when the object was originally
 * created.
 * 
 * @author tgh
 * 
 */
public interface Timestamped {

    public Calendar getCreationTimestamp();

    public void setCreationTimestamp(Calendar creationTimestamp);

    public Calendar getModificationTimestamp();

    public void setModificationTimestamp(Calendar modificationTimestamp);

    /**
     * AspectJ MixIn for any class which implements the interface. Provides a
     * default implementation using AspectJ. This is the style shown in
     * Manning's AspectJ in Action (2nd edition) for providing a default
     * implementation interface.
     * 
     * @author tgh
     */
    static aspect Impl {

        @NotNull
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "created", nullable=false)
        private Calendar Timestamped.creationTimestamp = Calendar.getInstance();

        @NotNull
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "last_modified", nullable=false)
        private Calendar Timestamped.modificationTimestamp = Calendar.getInstance();

        public Calendar Timestamped.getCreationTimestamp() {
            return this.creationTimestamp;
        }

        public void Timestamped.setCreationTimestamp(Calendar creationTimestamp) {
            this.creationTimestamp = creationTimestamp;
        }

        public Calendar Timestamped.getModificationTimestamp() {
            return this.modificationTimestamp;
        }

        public void Timestamped.setModificationTimestamp(Calendar modificationTimestamp) {
            this.modificationTimestamp = modificationTimestamp;
        }

        @PrePersist
        @PreUpdate
        private void Timestamped.updateModificationTimestampDuringPrePersistAndPreUpdate() {
            this.modificationTimestamp = Calendar.getInstance();
        }

    }
}