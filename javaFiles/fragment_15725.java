@Component
public class MyTomcatCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

@Value("${proxyName:}")
private String proxyName;

@Override
public void customize(TomcatServletWebServerFactory factory) {
    final Collection<Valve> currents = factory.getEngineValves();
    final ArrayList<Valve> addValves = new ArrayList<>(currents);
    if (StringUtils.hasLength(proxyName)) {
        addValves.add(0, new HostForceValve(proxyName));
    }
    factory.setEngineValves(addValves);
}
}