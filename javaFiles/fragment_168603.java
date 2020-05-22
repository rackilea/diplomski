public void init()
    {
        String userId1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userid");
        String jobId1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("jobid");
        userId = Long.parseLong(userId1);
        jobId = Long.parseLong(jobId1);

    }