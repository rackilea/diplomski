package de.professional_webworkx.so.controller;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Model
public class FireCalendarController {

    @Inject
    FacesContext context;

    private Date startDate;
    private Date endDate;
    private long duration;

    @Produces
    @Named
    public Date getStartDate() {
        Logger.getLogger(getClass().getSimpleName()).log(Level.INFO, "MSG");
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Produces
    @Named
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Produces
    @Named
    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void doSomething() {
        duration = endDate.getTime()-startDate.getTime();
        Logger.getLogger(getClass().getSimpleName()).log(Level.INFO, "Start was " + startDate);
    }


}