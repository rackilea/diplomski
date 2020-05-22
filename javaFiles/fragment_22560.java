package com.example.app;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class NotificationAspect {
    @Autowired private NotificationGateway notificationGateway;

    @Pointcut("execution(* com.example.app.ItemDeleter.delete(com.example.app.Item))")
    private void deleteItemOps() { }

    @AfterReturning(pointcut = "deleteItemOps() && args(item)")
    public void notifyDelete(Item item) {
        notificationGateway.notify(item, ConfigManagementEvent.OP_DELETE);
    }
}