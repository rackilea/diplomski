Prototype extracted = null;

if(AopUtils.isAopProxy(a) && a instanceof Advised) {
    Object target = ((Advised)a).getTargetSource().getTarget();
    extracted = (Prototype) target;
}