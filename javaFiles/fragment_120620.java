@RunWith(PaxExam.class)
class YourTest {
    @javax.inject.Inject
    protected BundleContext bundleContext_;

    @Test
    testMethod() {

        ServiceReference<AuditPageNavDao> daoServiceReference_ = bundleContext_.getServiceReference(AuditPageNavDao.class);
        AuditPageNavDao dao = bundleContext_.getService(daoServiceReference_);
        // use DAO here

    }
}