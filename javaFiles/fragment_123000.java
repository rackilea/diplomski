if (ResourceAdapter._isFixCR6760301())
 {
   localXASessionImpl = (XASessionImpl)this.xac.createSession(overrideTransacted(paramBoolean), overrideAcknowledgeMode(paramInt), (this.inACC) ? null : this.mc);
 }
 else {
   localXASessionImpl = (XASessionImpl)this.xac.createSession((this.mc.xaTransactionStarted()) ? true : paramBoolean, paramInt, (this.inACC) ? null : this.mc);
 }