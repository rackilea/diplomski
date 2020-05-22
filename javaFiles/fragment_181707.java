import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;    
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ErrorInterceptor {

    @Autowired
    private StateMachine<String, String> myStateMachine;

    @AfterThrowing(pointcut = "execution(* org.springframework.statemachine.guard.Guard.evaluate(*))", throwing = "ex")
    public void errorInterceptorGuard(Exception ex) {
        log.info("Error on Guard: " + myStateMachine.getState().getId() + " with Exception " + ex.toString());
        myStateMachine.setStateMachineError(ex);
    }

    @AfterThrowing(pointcut = "execution(* org.springframework.statemachine.action.Action.execute(*))", throwing = "ex")
    public void errorInterceptorAction(Exception ex) {
        log.info("Error on Action: " + myStateMachine.getState().getId() + " with Exception " + ex.toString());
        myStateMachine.setStateMachineError(ex);
    }
}