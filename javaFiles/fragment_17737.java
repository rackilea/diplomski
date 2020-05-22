package com.mtmrs.util.common;
import com.mtmrs.business.user.UserDetailManager;
import com.mtmrs.util.logger.MTMRSLogger;
import com.mtmrs.util.logger.ApplicationException;
import java.util.logging.Level;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class RunMeJob extends QuartzJobBean {

UserDetailManager userDetailManager;

public UserDetailManager getUserDetailManager() {
    return userDetailManager;
}

public void setUserDetailManager(UserDetailManager userDetailManager) {
    this.userDetailManager = userDetailManager;
}

@Override
protected void executeInternal(JobExecutionContext context)
        throws JobExecutionException {
    System.out.print("Entering Class: Job Class , method: execute");
    try {
        userDetailManager.sendMailTxnDetailsEveryNight();
    } catch (ApplicationException ex) {
        java.util.logging.Logger.getLogger(RunMeJob.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.print("Exiting Class: Job Class , method: execute");

}

}