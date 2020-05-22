/**
 * Indicate that the proxy should be exposed by the AOP framework as a {@code ThreadLocal}
 * for retrieval via the {@link org.springframework.aop.framework.AopContext} class.
 * Off by default, i.e. no guarantees that {@code AopContext} access will work.
 * @since 4.3.1
 */
boolean exposeProxy() default false;