@Inject MyUtil myUtil;
@Inject MyUtilWrapper myUtilWrapper;

void onCreate(..) {
  AndroidInjection.inject(this);
}