package test;

import java.math.BigDecimal;

public class TimerTuple {
    private BigDecimal shakeIncrement;
    private BigDecimal timerInterval;

    public TimerTuple(BigDecimal shakeIncrement, BigDecimal timerInterval) {
        this.shakeIncrement = shakeIncrement;
        this.timerInterval = timerInterval;
    }

    public BigDecimal getShakeIncrement() {
        return shakeIncrement;
    }

    public BigDecimal getTimerInterval() {
        return timerInterval;
    }
}