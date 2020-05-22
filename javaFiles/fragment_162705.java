@Stateless
class MainBean {
    @PersistenceContext EntityManager em1;
    @PersistenceContext EntityManager em2;
    ...
    @EJB WorkerBean1 workerBean1;
    @EJB WorkerBean2 workerBean2;
    ...
    void method1(Object param1, Object param2) {
        workerBean1.method1(em1, param1, param2);
    }

    void method2(Object param1, Object param2, Object param3) {
        workerBean2.method2(em2, param1, param2, param3);
    }
    ...
}

@Stateless
class WorkerBean1 {
    void method1(EntityManager em, Object param1, Object param2) {
        ...
    }
    ...
}

@Stateless
class WorkerBean2 {
    void method2(EntityManager em, Object param1, Object param2, Object param3) {
        ...
    }
    ...
}