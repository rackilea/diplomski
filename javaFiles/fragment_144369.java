import com.google.appengine.api.quota.QuotaService;
import com.google.appengine.api.quota.QuotaServiceFactory;

...
QuotaService qs = QuotaServiceFactory.getQuotaService();
long start = qs.getCpuTimeInMegaCycles();
doSomethingExpensive();
long end = qs.getCpuTimeInMegaCycles();
double cpuSeconds = qs.convertMegacyclesToCpuSeconds(end - start);